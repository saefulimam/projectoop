package com.UAS.apps

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Karyawan::class), version = 1)
abstract class KaryawanRoomDatabase : RoomDatabase() {
    abstract fun KaryawanPbk(): KaryawanPbk

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        KaryawanRoomDatabase::class.java, "DBKYN"
    ).build()

}