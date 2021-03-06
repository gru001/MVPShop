package com.example.pranit.mvpshop.data

import com.example.pranit.mvpshop.data.models.ShopResponse

/**
 * Created by pranit on 9/1/18.
 */
interface ShopDataSource {

    interface LoadCategoriesCallback {
        fun onCategoriesLoaded(response : ShopResponse?)
        fun onDataNotAvailable()
    }

    fun saveCategories(response: ShopResponse)

    fun getCategories(callback: ShopDataSource.LoadCategoriesCallback)

    fun deleteAllCategories()
}