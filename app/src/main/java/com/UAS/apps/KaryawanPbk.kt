package com.UAS.apps

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface KaryawanPbk {
    @Query("SELECT * FROM karyawan")
    fun getAll(): List<Karyawan>

    @Query("SELECT * FROM karyawan WHERE nip IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Karyawan>

    @Query("SELECT * FROM Karyawan WHERE nama LIKE :nama AND " +
            "divisi LIKE :divisi LIMIT 1")
    fun findByName(nama: String, divisi: String): Karyawan

    @Insert
    fun insertAll(vararg karyawan: Karyawan)

    @Delete
    fun delete(karyawan: Karyawan)
}
