package com.example.pranit.mvpshop.data.local

import android.support.annotation.VisibleForTesting
import com.example.pranit.mvpshop.data.ShopDataSource
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.util.AppExecutors

/**
 * Created by pranit on 9/1/18.
 */
class ShopLocalDataSource private constructor(val appExecutors: AppExecutors, val categoryDao: CategoryDao) : ShopDataSource {

    override fun saveCategories(categories: List<Category>) {
        appExecutors.diskIO.execute{
            for (category in categories) {
                categoryDao.insertCategory(category)
            }
        }
    }

    companion object {
        private var INSTANCE: ShopLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, categoryDao: CategoryDao): ShopLocalDataSource {
            if (INSTANCE == null) {
                synchronized(ShopLocalDataSource::javaClass) {
                    INSTANCE = ShopLocalDataSource(appExecutors, categoryDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }

}