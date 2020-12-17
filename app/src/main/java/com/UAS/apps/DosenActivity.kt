package com.UAS.apps

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.UAS.apps.Database.ApproomDB
import com.UAS.apps.EditDosenActivity
import com.UAS.apps.R
import kotlinx.android.synthetic.main.activity_dosen.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class DosenActivity : AppCompatActivity() {

    val db by lazy { ApproomDB(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dosen)
        setupListener()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val allDosen = db.DosenPbk().getAllDosen()
            Log.d("DosenActivity", "dbResponse: $allDosen")
        }
    }

    fun setupListener() {
        btn_createDosen.setOnClickListener {
            startActivity(Intent(this, EditDosenActivity::class.java))
        }
    }
}