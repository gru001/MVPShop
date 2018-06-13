package com.example.pranit.mvpshop.data

import com.example.pranit.mvpshop.data.local.ShopLocalDataSource
import com.example.pranit.mvpshop.data.models.ShopResponse
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
        cachedResponse = null
    }

    var cachIsDirty = true
    var cachedResponse: ShopResponse ?= null

    override fun getCategories(callback: ShopDataSource.LoadCategoriesCallback) {
        if (cachedResponse != null) {
            callback.onCategoriesLoaded(cachedResponse)
            return
        }

        if (cachIsDirty) {
            getCategoriesFromRemoteDatabase(callback)
        } else {
            shopLocalDataSource.getCategories(callback)
        }
    }

    private fun getCategoriesFromRemoteDatabase(callback: ShopDataSource.LoadCategoriesCallback) {
        shopRemoteDataSource.getCategories(object : ShopDataSource.LoadCategoriesCallback {
            override fun onCategoriesLoaded(response: ShopResponse?) {
                if (response != null) {
                    refreshCache(response)
                    refreshLocalDataSource(response)
                }
                callback.onCategoriesLoaded(response)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }

        })
    }

    private fun refreshLocalDataSource(response: ShopResponse) {
        shopLocalDataSource.deleteAllCategories()
        saveCategories(response)
    }

    private fun refreshCache(cachedResponse : ShopResponse) {
        this.cachedResponse = null
        this.cachedResponse = cachedResponse
        cachIsDirty = false
    }

    override fun saveCategories(response: ShopResponse) {
        shopLocalDataSource.saveCategories(response)
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