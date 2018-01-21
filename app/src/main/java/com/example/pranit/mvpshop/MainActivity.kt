package com.example.pranit.mvpshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.helper.PreferenceHelper
import com.example.pranit.mvpshop.shopingwindow.ShoppingContract
import com.example.pranit.mvpshop.shopingwindow.ShoppingPresenter

class MainActivity : AppCompatActivity(), ShoppingContract.View{
    override fun onCategoriesLoaded(categories: List<Category>) {

    }

    override lateinit var presenter: ShoppingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = ShoppingPresenter(Injection.provideTasksRepository(this), this)

        val pref = PreferenceHelper.defaultPrefs(this)

    }
}
