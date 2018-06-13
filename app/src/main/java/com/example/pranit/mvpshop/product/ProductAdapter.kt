package com.example.pranit.mvpshop.product

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Product

/**
 * Created by pranit on 19/1/18.
 */
class ProductAdapter(val product: ArrayList<Product>) :RecyclerView.Adapter<ProductAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return product.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent?.context).inflate(R.layout.item_product, parent,false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.txtvProduct?.text = product[position].name
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtvProduct: TextView = itemView as TextView
    }
}