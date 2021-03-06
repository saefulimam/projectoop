package com.lat.oopuas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager

import com.lat.oopuas.Database.AppRoomDB
import com.lat.oopuas.Database.Constant
import com.lat.oopuas.Database.Karyawan
import kotlinx.android.synthetic.main.activity_karyawan.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class KaryawanActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    lateinit var karyawanAdapter: KaryawanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karyawan)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadKaryawan()
    }

    fun loadKaryawan(){
        CoroutineScope(Dispatchers.IO).launch {
            val allKaryawan = db.karyawanDao().getAllKaryawan()
            Log.d("KaryawanActivity", "dbResponse: $allKaryawan")
            withContext(Dispatchers.Main) {
                karyawanAdapter.setData(allKaryawan)
            }
        }
    }

    fun setupListener() {
        btn_createKaryawan.setOnClickListener {
           intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun setupRecyclerView() {
        karyawanAdapter = KaryawanAdapter(arrayListOf(), object: KaryawanAdapter.OnAdapterListener {
            override fun onClick(karyawan: Karyawan) {
                // read detail
                intentEdit(karyawan.id, Constant.TYPE_READ)
            }

            override fun onDelete(karyawan: Karyawan) {
                // delete data
                deleteDialog(karyawan)
            }

            override fun onUpdate(karyawan: Karyawan) {
                // edit data
                intentEdit(karyawan.id, Constant.TYPE_UPDATE)
            }

        })
        list_karyawan.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = karyawanAdapter
        }
    }

    fun intentEdit(karyawanId: Int, intentType: Int ) {
        startActivity(
            Intent(applicationContext, EditKaryawanActivity::class.java)
                .putExtra("intent_id", karyawanId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun deleteDialog(karyawan: Karyawan) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Konfirmasi")
            setMessage("Yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.karyawanDao().deleteKaryawan(karyawan)
                    loadKaryawan()
                }
            }
        }
        alertDialog.show()
    }
}