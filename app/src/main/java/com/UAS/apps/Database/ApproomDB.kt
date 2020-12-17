package com.UAS.apps.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database (entities = arrayOf(Jabatan::class,Karyawan::class),version = 1)
abstract class ApproomDB:  RoomDatabase() {

    abstract fun JabatanPbk():JabatanPbk
    abstract fun KaryawanPbk():KaryawanPbk

    companion object {
        @Volatile
        private var INSTANCE: ApproomDB? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: builDatabase(context).also {

            }
        }

        private fun builDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                ApproomDB::class.java,
                "apps"
        ).build()

    }
}