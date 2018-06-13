package com.example.pranit.mvpshop.product

import com.example.pranit.mvpshop.BasePresenter
import com.example.pranit.mvpshop.BaseView
import com.example.pranit.mvpshop.data.models.Product

interface ProductContract {

    interface ProductView :BaseView<ProductPresenter>{
        fun onProductsLoaded(products : ArrayList<Product>)
        fun onDataFailedToLoad()
    }

    interface Presenter : BasePresenter {

    }
}