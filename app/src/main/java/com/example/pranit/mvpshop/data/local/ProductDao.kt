package com.example.pranit.mvpshop.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.pranit.mvpshop.TABLE_PRODUCT
import com.example.pranit.mvpshop.data.models.Product

/**
 * Created by pranit on 12/1/18.
 */
@Dao interface ProductDao {

    /**
     * Select all products from Table product
     *
     * @return all tasks.
     */
    @Query("SELECT * FROM $TABLE_PRODUCT")
    fun getProducts(): List<Product>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: Product)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM $TABLE_PRODUCT")
    fun deleteProducts()
}