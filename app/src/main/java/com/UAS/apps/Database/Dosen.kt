package com.UAS.apps.Database

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "Dosen")
data class Dosen(
        @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "dosen") val Dosen: String,
        parseInt: Int
)