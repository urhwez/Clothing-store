package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey (autoGenerate = true)
    var id_category: Int? = 0,
    @ColumnInfo(name = "type")
    var type: String,
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "subcategory")
    var subcategory: String,
    @ColumnInfo(name = "sex")
    var sex: Boolean
)
