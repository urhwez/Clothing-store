package com.example.opros

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Dao {
    @Insert(entity = Product::class)
    fun insertProduct(product: Product)
    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>
    @Query("SELECT * FROM products WHERE sex = 1 OR 3")
    fun getManProductDao(): List<Product>
    @Query("SELECT * FROM users")
    fun getUser(): List<Users>
    @Insert(entity = Users::class)
    fun insertUsers(user: Users)
    @Query("SELECT * FROM Users WHERE email = :email1 ")
    fun isAuthDao(email1: kotlin.String): Boolean

    @Insert(entity = Category::class)
    fun insertCategory(category: Category)

}
