package com.example.pranit.mvpshop.product

class ProductPresenter(val productPresenter: ProductPresenter, val productView: ProductContract.ProductView) : ProductContract.Presenter{

    init {
        productView.presenter = this
    }

    override fun start() {

    }
}