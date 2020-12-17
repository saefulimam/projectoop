package com.UAS.apps.Database

import androidx.room.*

@Dao
interface DosenPbk {
    @Insert
    suspend fun addDosen(dosen: Dosen)

    @Update
    suspend fun updateDosen(dosen: Dosen)

    @Delete
    suspend fun deleteDosen(dosen: Dosen)

    @Query("SELECT * FROM dosen")
    suspend fun getAllDosen(): List<Dosen>
}

