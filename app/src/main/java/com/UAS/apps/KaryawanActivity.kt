package com.UAS.apps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.UAS.apps.Database.ApproomDB
import kotlinx.android.synthetic.main.activity_karyawan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class KaryawanActivity : AppCompatActivity() {

    val db by lazy { ApproomDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karyawan)
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val allKaryawan = db.KaryawanPbk().getAllUser()
            Log.d("UserActivity", "dbResponse: $allKaryawan")
        }
    }

    fun setupListener() {
        btn_createKaryawan.setOnClickListener {
            startActivity(Intent(this, EditKaryawanActivity::class.java))
        }
    }

}