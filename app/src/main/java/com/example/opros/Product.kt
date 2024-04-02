package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "products", foreignKeys = [ForeignKey(entity = Category::class, parentColumns = ["id_category"], childColumns = ["product_category"], onDelete = ForeignKey.CASCADE, onUpdate = ForeignKey.CASCADE)
])
data class Product(
    @PrimaryKey (autoGenerate = true)
    var id_product: Int? = null,
    @ColumnInfo(name = "image")
    var image: String,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "brand")
    var brand: String,
    @ColumnInfo(name = "price")
    var price: Int,
    @ColumnInfo(name = "new_price")
    var new_price: Int,
    @ColumnInfo(name = "material")
    var material: String,
    @ColumnInfo(name = "color")
    var color: String,
    @ColumnInfo(name = "product_category")
    var product_category: Int,
    @ColumnInfo(name = "status")
    var status: Boolean
)

