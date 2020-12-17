package com.UAS.apps

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface DosenPbk {
    @Query("SELECT * FROM dosen")
    fun getAll(): List<Jabatan>

    @Query("SELECT * FROM dosen WHERE kode_jabatan IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Jabatan>

    @Query("SELECT * FROM dosen WHERE nama LIKE :nama AND " +
            "divisi LIKE :divisi LIMIT 1")
    fun findByName(nama: String, divisi: String): Jabatan

    @Insert
    fun insertAll(vararg mahasiswa: Dosen)

    @Delete
    fun delete(dosen: Dosen)
}
