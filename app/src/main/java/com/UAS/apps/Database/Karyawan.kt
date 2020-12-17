package com.UAS.apps.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "karyawan")
data class Karyawan(
    @PrimaryKey val nik: Int,
    @ColumnInfo(name = "nama") val nama: String?,
    @ColumnInfo(name = "Jabatan") val Jabatan: String
)
