package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey (autoGenerate = false)
    var id_category: Int,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "subcategory")
    var subcategory: String,
    @ColumnInfo(name = "sex")
    var sex: Int
)
