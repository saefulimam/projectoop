package com.UAS.apps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.UAS.apps.Database.ApproomDB
import com.UAS.apps.Database.Karyawan
import kotlinx.android.synthetic.main.activity_edit_karyawan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditKaryawanActivity : AppCompatActivity() {

    val db by lazy { ApproomDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_karyawan)
        setupListener()
    }

    fun setupListener(){
        btn_saveKaryawan.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.KaryawanPbk().addKaryawan(
                    Karyawan(0, txt_nik.text.toString(), txt_nama.text.toString())
                )
                finish()
            }
        }
    }
}