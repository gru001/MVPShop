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
    @Query("SELECT * FROM $TABLE_PRODUCT") fun getProducts(): List<Product>


    @Query("SELECT * FROM $TABLE_PRODUCT WHERE (category_id = :arg0 AND viewCount IS NOT NULL)")
    fun getMostViewdProduct(categoryId: Int):List<Product>

    @Query("SELECT * FROM $TABLE_PRODUCT WHERE (category_id = :arg0 AND shares IS NOT NULL)")
    fun getMostSharedProduct(categoryId: Int):List<Product>

    @Query("SELECT * FROM $TABLE_PRODUCT WHERE (category_id = :arg0 AND orderCount IS NOT NULL)")
    fun getMostOrderedProduct(categoryId: Int):List<Product>

    /**
     * Inserts product data into local database
     *
     * @param product data
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insertProduct(product: Product)

    /**
     * Delete all products.
     */
    @Query("DELETE FROM $TABLE_PRODUCT") fun deleteProducts()

    /**
     * Get product by id
     *
     * @return product's id looking into database
     *
     * Kotlin isn't preserving argument name properly have to use arg0
     * https://stackoverflow.com/a/44212557
     */
    @Query("SELECT * FROM $TABLE_PRODUCT WHERE prod_id = :arg0")
    fun getProductById(productId : Int) :Product

    @Query("UPDATE $TABLE_PRODUCT SET viewCount= :arg0, orderCount= :arg1, shares= :arg2 WHERE prod_id= :arg3")
    fun updateRanking(viewCount: Int?, orderCount:Int?, shares:Int?, prodId:Int?)

    /**
     * Get products by category Id
     *
     * @param categoryId to fetch all products
     * @return Products by category
     *
     * Kotlin isn't preserving argument name properly have to use arg0
     * https://stackoverflow.com/a/44212557
     */
    @Query("SELECT * FROM $TABLE_PRODUCT WHERE category_id = :arg0")
    fun getProductsByCateogryId(categoryId : Int) :List<Product>
}