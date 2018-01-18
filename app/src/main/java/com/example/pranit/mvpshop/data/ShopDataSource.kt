package com.example.pranit.mvpshop.data

import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 9/1/18.
 */
interface ShopDataSource {

    interface LoadCategoriesCallback {
        fun onCategoriesLoaded(categories: List<Category>)
        fun onDataNotAvailable()
    }

    fun saveCategories(categories: List<Category>)

    fun getCategories(callback: ShopDataSource.LoadCategoriesCallback)

    fun deleteAllCategories()
}