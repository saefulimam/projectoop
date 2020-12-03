package com.lat.myapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Siswa::class), version = 1)
abstract class DosenRoomDatabase : RoomDatabase() {
    abstract fun Dosendb(): Dosendb

    abstract val applicationContext: Context
    val db = Room.databaseBuilder(
        applicationContext,
        DosenRoomDatabase::class.java, "DBKYN"
    ).build()

}