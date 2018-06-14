package com.example.pranit.mvpshop.product

import com.example.pranit.mvpshop.data.models.Product
import com.example.pranit.mvpshop.data.product.ProductLocalDataSource

class ProductPresenter(val dataSource: ProductLocalDataSource, val productView: ProductContract.ProductView) : ProductContract.Presenter{
    override fun start() {

    }

    init {
        productView.presenter = this
    }


    fun loadProducts(callback: ProductLocalDataSource.LoadProductsCallback) {
        dataSource.getProductByCategory(1, object :ProductLocalDataSource.LoadProductsCallback{
            override fun onProductLoaded(productList: List<Product>?) {
                callback.onProductLoaded(productList)
            }

        })
    }
}