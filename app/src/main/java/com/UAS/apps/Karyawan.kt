package com.UAS.apps

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "karyawan")
data class Karyawan(
            @PrimaryKey val nip: Int,
            @ColumnInfo(name = "nama") val nama: String?,
            @ColumnInfo(name = "Jabatan") val Jabatan : String?
)
