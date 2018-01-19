package com.example.pranit.mvpshop.data

import com.example.pranit.mvpshop.data.local.ShopLocalDataSource
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.data.remote.ShopRemoteDataSource

/**
 * Created by pranit on 9/1/18.
 */
class ShopRepository(
        val shopLocalDataSource: ShopLocalDataSource,
        val shopRemoteDataSource: ShopRemoteDataSource) : ShopDataSource {

    override fun deleteAllCategories() {
        shopLocalDataSource.deleteAllCategories()
        shopRemoteDataSource.deleteAllCategories()
        cachedCategories.clear()
    }

    var cachIsDirty = false
    var cachedCategories: ArrayList<Category> = ArrayList()

    override fun getCategories(callback: ShopDataSource.LoadCategoriesCallback) {
        if (cachedCategories.isNotEmpty() && !cachIsDirty) {
            callback.onCategoriesLoaded(cachedCategories)
            return
        }

        if (cachIsDirty) {
            getCategoriesFromRemoteDatabase(callback)
        } else {

        }
        shopRemoteDataSource.getCategories(callback)
    }

    private fun getCategoriesFromRemoteDatabase(callback: ShopDataSource.LoadCategoriesCallback) {
        shopRemoteDataSource.getCategories(object : ShopDataSource.LoadCategoriesCallback {
            override fun onCategoriesLoaded(categories: List<Category>) {
                refreshCache(categories)
                refreshLocalDataSource(categories)
                callback.onCategoriesLoaded(categories)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

        })
    }

    private fun refreshLocalDataSource(categories: List<Category>) {
        shopLocalDataSource.deleteAllCategories()
    }

    private fun refreshCache(categories: List<Category>) {
        cachedCategories.clear()
        cachedCategories.addAll(categories)
        cachIsDirty = false
    }

    override fun saveCategories(categories: List<Category>) {
        shopLocalDataSource.saveCategories(categories)
    }

    companion object {
        private var INSTANCE: ShopRepository? = null

        /**
         * Returns the single instance of Repository class
         *
         * @param shopLocalDataSource the local storage data source
         *
         */
        @JvmStatic
        fun getInstance(shopLocalDataSource: ShopLocalDataSource,
                        shopRemoteDataSource: ShopRemoteDataSource): ShopRepository {
            return INSTANCE ?: ShopRepository(shopLocalDataSource, shopRemoteDataSource).apply { INSTANCE = this }
        }
    }

}