package com.example.pranit.mvpshop.data.product

import android.util.Log
import com.example.pranit.mvpshop.data.local.ProductDao
import com.example.pranit.mvpshop.data.local.ShopLocalDataSource
import com.example.pranit.mvpshop.data.models.Product
import com.example.pranit.mvpshop.util.AppExecutors

class ProductLocalDataSource private constructor(val appExecutors: AppExecutors, val productDao: ProductDao) {


    interface LoadProductsCallback{
        fun onProductLoaded(productList: List<Product>?)
    }

    fun getProductByCategory(categoryId: Int, callback: LoadProductsCallback) {
        appExecutors.diskIO.execute{
            Log.i(ProductLocalDataSource::class.java.name, "${productDao.getProductsByCateogryId(categoryId)?.size}")
            callback.onProductLoaded(productDao.getProductsByCateogryId(categoryId))
        }
    }

    companion object {
        private var INSTANCE : ProductLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, productDao: ProductDao) : ProductLocalDataSource {

            if (INSTANCE == null) {
                synchronized(ShopLocalDataSource::class.java) {
                    INSTANCE = ProductLocalDataSource(appExecutors, productDao)
                }
            }

            return INSTANCE!!
        }
    }
}