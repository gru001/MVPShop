package com.example.pranit.mvpshop.product

import com.example.pranit.mvpshop.data.product.ProductLocalDataSource

class ProductPresenter(val dataSource: ProductLocalDataSource, val productView: ProductContract.ProductView) : ProductContract.Presenter{
    override fun start() {

    }

    init {
        productView.presenter = this
    }


    fun loadProducts(categoryId: Int, callback: ProductLocalDataSource.LoadProductsCallback) {
        dataSource.getProductByCategory(categoryId, callback)
    }

    fun loadMostViewedProducts(categoryId: Int, callback: ProductLocalDataSource.LoadProductsCallback){
        dataSource.getProductMostViewed(categoryId, callback)
    }

    fun loadMostSharedProducts(categoryId: Int, callback: ProductLocalDataSource.LoadProductsCallback){
        dataSource.getProductMostShared(categoryId, callback)
    }

    fun loadMostOrderedProducts(categoryId: Int, callback: ProductLocalDataSource.LoadProductsCallback){
        dataSource.getProductMostOrdered(categoryId, callback)
    }
}