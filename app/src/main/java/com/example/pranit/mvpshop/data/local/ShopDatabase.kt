package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.data.models.Product
import com.example.pranit.mvpshop.data.models.Variant

/**
 * Created by pranit on 12/1/18.
 */
@Database(entities = arrayOf(Category::class, Product::class, Variant::class), version = 1)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun categoryDao() : CategoryDao

    abstract fun productDao() : ProductDao

    abstract fun taxDao() : TaxDao

    abstract fun variantDao() : VariantDao

    companion object {
        private var INSTANCE: ShopDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): ShopDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            ShopDatabase::class.java, "shops.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}