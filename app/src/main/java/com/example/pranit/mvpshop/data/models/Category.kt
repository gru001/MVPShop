package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.pranit.mvpshop.TABLE_CATEGORY
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_CATEGORY)
class Category {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @ColumnInfo
    @SerializedName("name")
    @Expose
    var name: String? = null

    /*@SerializedName("products")
    @Expose
    var products: List<Product>? = null
    @SerializedName("child_categories")
    @Expose
    var childCategories: List<Int>? = null*/

}
