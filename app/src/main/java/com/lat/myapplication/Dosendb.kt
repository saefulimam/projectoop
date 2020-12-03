package com.lat.myapplication

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

interface Dosendb {
    interface Dosendb {
        @Query("SELECT * FROM dosen")
        fun getAll(): List<Dosen>

        @Query("SELECT * FROM Dosen WHERE idDosen IN (:userIds)")
        fun loadAllByIds(userIds: IntArray): List<Dosen>

        @Query("SELECT * FROM nama WHERE nama LIKE :nama AND " +
                "divisi LIKE :divisi LIMIT 1")
        fun findByName(nama: String, divisi: String): Dosen

        @Insert
        fun insertAll(vararg dosen: Dosen)

        @Delete
        fun delete(dosen: Dosen)
    }
}