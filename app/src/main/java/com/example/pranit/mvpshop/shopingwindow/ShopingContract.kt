package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.BasePresenter
import com.example.pranit.mvpshop.BaseView

/**
 * Created by pranit on 12/1/18.
 */
interface ShopingContract {
    interface View : BaseView<ShopingPresenter>{
    }

    interface Presenter:BasePresenter{

    }
}