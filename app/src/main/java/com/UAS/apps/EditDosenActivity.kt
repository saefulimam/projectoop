package com.UAS.apps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.UAS.apps.Database.ApproomDB
import com.UAS.apps.Database.Dosen
import kotlinx.android.synthetic.main.activity_edit_dosen.*
import kotlinx.android.synthetic.main.activity_edit_karyawan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

class EditDosenActivity : AppCompatActivity() {

    val db by lazy { ApproomDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_dosen)
        setupListener()
    }

    fun setupListener(){
        btn_saveDosen.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.DosenPbk().addDosen(
                    Dosen(0, txt_id.text.toString(), Integer.parseInt(txt_dosen.text.toString()))
                )
                finish()
            }
        }
    }
}