package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ProductSize",  foreignKeys = [androidx.room.ForeignKey(
    entity = com.example.opros.Sizes::class,
    parentColumns = ["id_sizes"],
    childColumns = ["size_id"],
    onDelete = androidx.room.ForeignKey.CASCADE,
    onUpdate = androidx.room.ForeignKey.CASCADE
), ForeignKey( entity = Users::class,
    parentColumns = ["id_product"],
    childColumns = ["product_id"],
    onDelete = ForeignKey.CASCADE,
    onUpdate = ForeignKey.CASCADE)
])
data class ProductSize(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo(name = "size_id")
    var size_id: Int,
    @ColumnInfo(name = "product_id")
    var product_id: Int
)
