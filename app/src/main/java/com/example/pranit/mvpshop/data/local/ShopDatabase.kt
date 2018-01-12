package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.data.models.Product

/**
 * Created by pranit on 12/1/18.
 */
@Database(entities = arrayOf(Category::class, Product::class), version = 1)
abstract class ShopDatabase : RoomDatabase() {

}