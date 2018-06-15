package com.example.pranit.mvpshop.product

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.pranit.mvpshop.Injection
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Product
import com.example.pranit.mvpshop.data.product.ProductLocalDataSource

class ProductActivity :AppCompatActivity(), ProductContract.ProductView, AdapterView.OnItemSelectedListener, ProductLocalDataSource.LoadProductsCallback{
    override fun onProductLoaded(productList: List<Product>?) {
        runOnUiThread { recyclerView?.adapter = ProductAdapter(productList as ArrayList<Product>) }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (position != 0) {
            val categoryId = intent.getIntExtra(ProductActivity.ARG_CATEGORY_ID, 0)
            when(position) {
                1 -> presenter.loadMostViewedProducts(categoryId, this)
                2 -> presenter.loadMostOrderedProducts(categoryId, this)
                3 -> presenter.loadMostSharedProducts(categoryId, this)
            }
        }
    }

    override lateinit var presenter: ProductPresenter

    override fun onProductsLoaded(products: ArrayList<Product>) {
        recyclerView?.adapter = ProductAdapter(products)
    }

    override fun onDataFailedToLoad() {
        Toast.makeText(this, "Failed to load data.", Toast.LENGTH_SHORT).show()
    }

    var recyclerView: RecyclerView? = null
    var spnrRanking: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        recyclerView = findViewById(R.id.recy_products)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        recyclerView?.hasFixedSize()
        spnrRanking = findViewById(R.id.spnr_ranking)
        val adapter = ArrayAdapter.createFromResource(this, R.array.ranking_array, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnrRanking?.adapter = adapter
        spnrRanking?.onItemSelectedListener = this
        presenter = ProductPresenter(Injection.provideProductRepository(this), this)
    }

    override fun onResume() {
        super.onResume()
        val categoryId = intent.getIntExtra(ProductActivity.ARG_CATEGORY_ID, 0)
        presenter.loadProducts(categoryId, this)
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