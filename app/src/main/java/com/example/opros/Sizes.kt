package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sizes")
data class Sizes(
    @PrimaryKey (autoGenerate = true)
    var id_sizes: Int? = null,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "count")
    var count: Int
)
