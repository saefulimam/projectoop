package com.UAS.apps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_jabatan.setOnClickListener{
            val intent = Intent(this, JabatanActivity::class.java)
            startActivity(intent)
        }

        btn_karyawan.setOnClickListener{
            val intent = Intent(this, KaryawanActivity::class.java)
            startActivity(intent)
        }
    }
}