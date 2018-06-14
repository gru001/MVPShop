package com.example.pranit.mvpshop.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.example.pranit.mvpshop.Injection
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Product
import com.example.pranit.mvpshop.data.product.ProductLocalDataSource

class ProductActivity :AppCompatActivity(), ProductContract.ProductView{
    override lateinit var presenter: ProductPresenter

    override fun onProductsLoaded(products: ArrayList<Product>) {
        recyclerView?.adapter = ProductAdapter(products)
    }

    override fun onDataFailedToLoad() {
        Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
    }

    var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        recyclerView = findViewById(R.id.recy_products)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.hasFixedSize()
        presenter = ProductPresenter(Injection.provideProductRepository(this), this)
    }

    override fun onResume() {
        super.onResume()
        presenter.loadProducts(object : ProductLocalDataSource.LoadProductsCallback{
            override fun onProductLoaded(productList: List<Product>?) {
                recyclerView?.adapter = ProductAdapter(productList as ArrayList<Product>)
            }

        })
    }

    companion object {
        val ARG_CATEGORY_ID = "CATEGORY_ID"
        @JvmStatic
        fun getStartIntent(context: Context, categoryId : Int) : Intent{
            val intent = Intent(context, ProductActivity::class.java)
            intent.putExtra(ARG_CATEGORY_ID, categoryId)
            return intent
        }
    }
}