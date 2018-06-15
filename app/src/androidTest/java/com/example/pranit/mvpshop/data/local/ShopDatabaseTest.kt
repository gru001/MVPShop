package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Room
import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.pranit.mvpshop.data.models.Category
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ShopDatabaseTest {
    var categoryDao : CategoryDao? = null
    var shopDataBase: ShopDatabase? = null

    @Before
    fun before() {
        val context: Context = InstrumentationRegistry.getTargetContext()
        shopDataBase = Room.inMemoryDatabaseBuilder(context, ShopDatabase::class.java).build()
        categoryDao = shopDataBase?.categoryDao()
    }

    @After
    fun after() {
        shopDataBase?.close()
    }

    @Throws(Exception::class)
    fun writeAndReadInList() {
        val category =  Category()
        category.id = 1
        category.name = "Jeans"
        categoryDao?.insertCategory(category)

        val categories = categoryDao?.findCategoriesByName("Jeans")
        assertEquals(category, categories!!.get(0))
    }
}