package com.example.pranit.mvpshop.product

import com.example.pranit.mvpshop.data.product.ProductLocalDataSource

class ProductPresenter(val dataSource: ProductLocalDataSource, val productView: ProductContract.ProductView) : ProductContract.Presenter{

    init {
        productView.presenter = this
    }

    override fun start() {
        loadProducts()
    }

    fun loadProducts() {
        dataSource.getProductByCategory(1)
    }
}