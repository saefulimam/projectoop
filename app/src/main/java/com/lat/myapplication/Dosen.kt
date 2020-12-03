package com.lat.myapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text

@Entity(tableName = "dosen")
    data class Dosen (

        @PrimaryKey val idDosen: Int,
        @ColumnInfo(name = "nama") val nama: Text?,
        @ColumnInfo(name = "jabatan") val jabatan : Text?
    )
