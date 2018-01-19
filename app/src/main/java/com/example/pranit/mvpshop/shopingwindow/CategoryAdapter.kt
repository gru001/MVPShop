package com.example.pranit.mvpshop.shopingwindow

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 19/1/18.
 */
class CategoryAdapter(val categories: ArrayList<Category>) :RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent?.context).inflate(R.layout.item_category, parent,false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }
}