package com.UAS.apps

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.w3c.dom.Text
import java.text.DecimalFormat


@Entity(tableName = "dosen")
data class Dosen (
        @PrimaryKey val kode_dosen: Text,
        @ColumnInfo(name = "nama_dosen") val nama_dosen: Text?,
        @ColumnInfo(name = "tunjangan_Dosen") val tunjangan_Dosen : DecimalFormat?
)