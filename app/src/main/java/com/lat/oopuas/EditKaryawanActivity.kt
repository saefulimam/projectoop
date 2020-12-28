package com.lat.oopuas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lat.oopuas.Database.AppRoomDB
import com.lat.oopuas.Database.Constant
import com.lat.oopuas.Database.Karyawan
import kotlinx.android.synthetic.main.activity_edit_karyawan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditKaryawanActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    private var karyawanId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_karyawan)
        setupListener()
        setupView()
    }

    fun setupListener(){
        btn_saveKaryawan.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.karyawanDao().addKaryawan(
                    Karyawan(0, txt_nama.text.toString(), Integer.parseInt(txt_nip.text.toString()), Integer.parseInt(txt_no_hp.text.toString()) )
                )
                finish()
            }
        }
        btn_updateKaryawan.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.karyawanDao().updateKaryawan(
                    Karyawan(karyawanId, txt_nama.text.toString(), Integer.parseInt(txt_nip.text.toString()), Integer.parseInt(txt_no_hp.text.toString()) )
                )
                finish()
            }
        }
    }

    fun setupView() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constant.TYPE_CREATE -> {
                btn_updateKaryawan.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_saveKaryawan.visibility = View.GONE
                btn_updateKaryawan.visibility = View.GONE
                getKaryawan()
            }
            Constant.TYPE_UPDATE -> {
                btn_saveKaryawan.visibility = View.GONE
                getKaryawan()
            }
        }
    }

    fun getKaryawan() {
        karyawanId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
           val karyawans =  db.karyawanDao().getKaryawan( karyawanId )[0]
            txt_nama.setText( karyawans.nama )
            txt_nip.setText( karyawans.nip.toString() )
            txt_no_hp.setText( karyawans.no_hp.toString() )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}