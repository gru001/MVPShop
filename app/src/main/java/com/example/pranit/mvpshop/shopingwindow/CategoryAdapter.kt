package com.example.pranit.mvpshop.shopingwindow

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.pranit.mvpshop.R
import com.example.pranit.mvpshop.data.models.Category

/**
 * Created by pranit on 19/1/18.
 */
class CategoryAdapter(val listener: OnCategoryClickListener,val categories: ArrayList<Category>) :RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent?.context).inflate(R.layout.item_category, parent,false)
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.txtvCategory?.text = categories[position].name
        holder?.bind(categories.get(position), listener)
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val txtvCategory: TextView = itemView as TextView

        fun bind(item: Category, listener: OnCategoryClickListener) {
            txtvCategory.setOnClickListener{
                listener.onCategoryClick(item)
            }
        }

    }

    interface OnCategoryClickListener {
        fun onCategoryClick(item: Category?)
    }
}