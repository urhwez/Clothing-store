package com.example.opros

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Order",  foreignKeys = [androidx.room.ForeignKey(
    entity = com.example.opros.Users::class,
    parentColumns = ["id_user"],
    childColumns = ["user_id"],
    onDelete = androidx.room.ForeignKey.CASCADE,
    onUpdate = androidx.room.ForeignKey.CASCADE
), ForeignKey( entity = com.example.opros.Users::class,
    parentColumns = ["id_product"],
    childColumns = ["product_id"],
    onDelete = androidx.room.ForeignKey.CASCADE,
    onUpdate = androidx.room.ForeignKey.CASCADE)
])
data class Order(
    @PrimaryKey (autoGenerate = true)
    var id: Int? = null,
    @ColumnInfo (name = "user_id")
    var user_id: Int,
    @ColumnInfo (name = "product_id")
    var product_id: Int
)
