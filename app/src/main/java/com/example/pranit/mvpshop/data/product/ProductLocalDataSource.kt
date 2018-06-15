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

    fun getProductMostViewed(categoryId: Int, callback: LoadProductsCallback) {
        appExecutors.diskIO.execute{
            Log.i(ProductLocalDataSource::class.java.name, "${productDao.getProductsByCateogryId(categoryId)?.size}")
            callback.onProductLoaded(productDao.getMostViewdProduct(categoryId))
        }
    }

    fun getProductMostShared(categoryId: Int, callback: LoadProductsCallback) {
        appExecutors.diskIO.execute{
            Log.i(ProductLocalDataSource::class.java.name, "${productDao.getProductsByCateogryId(categoryId)?.size}")
            callback.onProductLoaded(productDao.getMostSharedProduct(categoryId))
        }
    }

    fun getProductMostOrdered(categoryId: Int, callback: LoadProductsCallback) {
        appExecutors.diskIO.execute{
            Log.i(ProductLocalDataSource::class.java.name, "${productDao.getProductsByCateogryId(categoryId)?.size}")
            callback.onProductLoaded(productDao.getMostOrderedProduct(categoryId))
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