package com.example.opros

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Product::class, Order::class, Sizes::class, Category::class, Users::class,  ProductSize::class], version = 1)
abstract class ShopDB : RoomDatabase() {
    abstract fun getDao():Dao
    
    companion object{
        fun getDB(context: Context): ShopDB{
            return Room.databaseBuilder(
                context.applicationContext,
                ShopDB::class.java,
                "shop.db"
            ).build()
        }
    }
}