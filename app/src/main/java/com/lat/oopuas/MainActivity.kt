package com.lat.oopuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_karyawan.setOnClickListener{
            val intent = Intent(this, KaryawanActivity::class.java)
            startActivity(intent)
        }

//        btn_bos.setOnClickListener{
//            val intent = Intent(this, UserActivity::class.java)
//            startActivity(intent)
//        }





    }
}