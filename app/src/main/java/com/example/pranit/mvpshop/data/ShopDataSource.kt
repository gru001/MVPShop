package com.example.pranit.mvpshop.data

import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 9/1/18.
 */
interface ShopDataSource {
    fun saveCategories(categories: List<Category>)
}