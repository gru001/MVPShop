package com.example.pranit.mvpshop.data.product

import com.example.pranit.mvpshop.data.local.ProductDao
import com.example.pranit.mvpshop.data.local.ShopLocalDataSource
import com.example.pranit.mvpshop.util.AppExecutors

class ProductLocalDataSource private constructor(val appExecutors: AppExecutors, val productDao: ProductDao) {



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