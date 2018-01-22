package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.BasePresenter
import com.example.pranit.mvpshop.BaseView
import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 12/1/18.
 */
interface ShoppingContract {
    interface View : BaseView<ShoppingPresenter>{
        fun onCategoriesLoaded(categories: ArrayList<Category>)
    }

    interface Presenter:BasePresenter{

    }
}