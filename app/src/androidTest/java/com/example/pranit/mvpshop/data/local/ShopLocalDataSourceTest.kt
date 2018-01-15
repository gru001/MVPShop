package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.util.SingleExecutors
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by pranit on 15/1/18.
 */
@RunWith(AndroidJUnit4::class) @LargeTest class ShopLocalDataSourceTest {
    private lateinit var localDataSource: ShopLocalDataSource
    private lateinit var database: ShopDatabase

    @Before
    fun setup() {
        // using an in-memory database for testing, since it doesn't survive killing the process
        database = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                ShopDatabase::class.java)
                .build()

        ShopLocalDataSource.clearInstance()
        localDataSource = ShopLocalDataSource.getInstance(SingleExecutors(), database.categoryDao())
    }

    @After
    fun cleanUp() {
        database.close()
        ShopLocalDataSource.clearInstance()
    }

    @Test fun saveTask_retrievesTask() {
        val category = Category()
        category.id = 1
        category.name = "jeans"
        val categories = listOf(category)

        with(localDataSource) {
            saveCategories(categories)
        }
    }
}