package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pranit.mvpshop.TABLE_CATEGORY
import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 12/1/18.
 */
@Dao interface CategoryDao {

    /**
     * Select all categories from Table product
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM $TABLE_CATEGORY")
    fun getCategories(): List<Category>

    @Query("SELECT * FROM $TABLE_CATEGORY WHERE name = :arg0")
    fun findCategoriesByName(categoryName: String): List<Category>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(category: Category)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM $TABLE_CATEGORY")
    fun deleteProducts()

}