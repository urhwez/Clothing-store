package com.example.opros

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface Dao {
    @Insert
    fun insertProduct(product: Product)
    @Query("SELECT * FROM products")
    fun getAllProducts(): List<Product>
    fun getUser(): List<Users>
    @Insert
    fun insertUsers(user: Users)
    @Query("SELECT * FROM Users WHERE email = :email1 and password = :pas")
    fun getAllUsers(email1: kotlin.String, pas: kotlin.String,): List<Users>
    @Query("SELECT * FROM Users WHERE email = :email1 and password = :pas")
    fun isAuth(email1: kotlin.String, pas: kotlin.String): Boolean

}
