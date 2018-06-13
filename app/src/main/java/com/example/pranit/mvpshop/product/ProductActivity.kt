package com.example.pranit.mvpshop.product

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Product

class ProductActivity :AppCompatActivity(), ProductContract.ProductView{
    override lateinit var presenter: ProductPresenter

    override fun onProductsLoaded(products: ArrayList<Product>) {
        recyclerView?.adapter = ProductAdapter(products)
    }

    override fun onDataFailedToLoad() {
        Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
    }

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_product)
        recyclerView = findViewById(R.id.recy_products)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.hasFixedSize()
    }

    override fun onResume() {
        super.onResume()
        presenter.start()
    }
}