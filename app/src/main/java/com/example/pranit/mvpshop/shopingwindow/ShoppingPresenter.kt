package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.data.ShopRepository

/**
 * Created by pranit on 12/1/18.
 */
class ShoppingPresenter(val shopRepository: ShopRepository, val shopView: ShoppingContract.View) : ShoppingContract.Presenter {

    override fun start() {

    }
}