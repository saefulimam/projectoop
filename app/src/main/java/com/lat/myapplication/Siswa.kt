package com.lat.myapplication
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text

@Entity(tableName = "siswa")
data class Siswa (

    @PrimaryKey val nim: Int,
    @ColumnInfo(name = "nama") val nama: Text?,
    @ColumnInfo(name = "kelas") val kelas : Int?
    )
