package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.BasePresenter
import com.example.pranit.mvpshop.BaseView

/**
 * Created by pranit on 12/1/18.
 */
interface ShoppingContract {
    interface View : BaseView<ShoppingPresenter>{
    }

    interface Presenter:BasePresenter{

    }
}