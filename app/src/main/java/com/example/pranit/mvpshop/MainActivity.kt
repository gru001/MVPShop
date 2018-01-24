package com.example.pranit.mvpshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.pranit.mvpshop.data.models.Category
import com.example.pranit.mvpshop.helper.PreferenceHelper
import com.example.pranit.mvpshop.shopingwindow.CategoryAdapter
import com.example.pranit.mvpshop.shopingwindow.ShoppingContract
import com.example.pranit.mvpshop.shopingwindow.ShoppingPresenter

class MainActivity : AppCompatActivity(), ShoppingContract.View{

    override lateinit var presenter: ShoppingPresenter
    var pref:PreferenceHelper? = null
    var recyclerView : RecyclerView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recy_category)
        recyclerView?.layoutManager = LinearLayoutManager(this)

        presenter = ShoppingPresenter(Injection.provideTasksRepository(this), this)

        pref = PreferenceHelper(this)

        val isDataLoaded:Boolean = pref!!.isDataLoaded()
        if(isDataLoaded) {
            presenter.fetchDataFromServer = false
        }

    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onCategoriesLoaded(categories: ArrayList<Category>) {
        pref!!.setDataLoaded(true)
        runOnUiThread {
            recyclerView?.adapter = CategoryAdapter(categories)
        }
    }
}
