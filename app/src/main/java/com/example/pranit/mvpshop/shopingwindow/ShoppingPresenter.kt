package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.data.ShopDataSource
import com.example.pranit.mvpshop.data.ShopRepository
import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 12/1/18.
 */
class ShoppingPresenter(val shopRepository: ShopRepository, val shopView: ShoppingContract.View) : ShoppingContract.Presenter {

    init {
        shopView.presenter = this
    }

    var fetchDataFromServer = true

    override fun start() {
        shopRepository.cachIsDirty = fetchDataFromServer
        loadCategories()
    }

    private fun loadCategories() {
        shopRepository.getCategories(object :ShopDataSource.LoadCategoriesCallback{
            override fun onCategoriesLoaded(categories: List<Category>) {
                shopView.onCategoriesLoaded(categories as ArrayList<Category>)
            }

            override fun onDataNotAvailable() {

            }

        })
    }
}