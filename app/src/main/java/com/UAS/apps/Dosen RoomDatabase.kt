package com.UAS.apps

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Jabatan::class), version = 1)
abstract class DosenRoomDatabase : RoomDatabase() {
    abstract fun DosenPbk(): DosenPbk

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
            applicationContext,
            JabatanRoomDatabase::class.java, "DBKYN"
    ).build()

}