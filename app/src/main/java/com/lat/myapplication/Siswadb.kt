package com.lat.myapplication

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface Siswadb {
    interface Siswadb {
        @Query("SELECT * FROM Siswa")
        fun getAll(): List<Siswa>

        @Query("SELECT * FROM Siswa WHERE nim IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<Siswa>

        @Query("SELECT * FROM Siswa WHERE nama LIKE :nama AND " +
                "divisi LIKE :divisi LIMIT 1")
        fun findByName(nama: String, divisi: String): Siswa

        @Insert
        fun insertAll(vararg siswa: Siswa)

        @Delete
        fun delete(siswa: Siswa)
    }
}