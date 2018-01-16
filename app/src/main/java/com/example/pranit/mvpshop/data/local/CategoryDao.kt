package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pranit.mvpshop.TABLE_CATEGORY
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.data.models.Product

/**
 * Created by pranit on 12/1/18.
 */
@Dao interface CategoryDao {

    /**
     * Select all products from Table product
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM $TABLE_CATEGORY")
    fun getProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM $TABLE_CATEGORY")
    fun deleteProducts()

}