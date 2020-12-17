package com.UAS.apps.Database

import androidx.room.*

@Dao
interface KaryawanPbk {
    @Insert
    suspend fun addKaryawan(karyawan: Karyawan)

    @Update
    suspend fun updateKaryawan(karyawan: Karyawan)

    @Delete
    suspend fun deleteKaryawan(karyawan: Karyawan)

    @Query("SELECT * FROM karyawan")
    suspend fun getAllUser(): List<Karyawan>
}
