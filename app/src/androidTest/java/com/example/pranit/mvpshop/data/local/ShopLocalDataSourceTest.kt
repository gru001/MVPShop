package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import com.example.pranit.mvpshop.data.models.*
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
        localDataSource = ShopLocalDataSource.getInstance(SingleExecutors(), database.categoryDao(), database.productDao(), database.variantDao())
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
        category.products = listOf(Product()
                .apply { category_id = 1
         prod_id = 10
                variants = listOf(Variant().apply { id = 1
                product_id = 10
                prod_id = 10})})
        val categories = listOf(category)
        val shopResponse = ShopResponse()
        shopResponse.categories = categories

        val ranking = Ranking()
        ranking.ranking = "Most Viewed"
        ranking.products = listOf(Product_().apply { id = 100 })
        shopResponse.rankings = listOf(ranking)
        with(localDataSource) {
            saveCategories(shopResponse)
        }
    }
}