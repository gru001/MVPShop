package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(foreignKeys = [(ForeignKey(entity = Category::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("category_id"),
        onDelete = ForeignKey.CASCADE))])
class Product {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var prod_id: Int? = null

    @ColumnInfo
    @SerializedName("name")
    @Expose
    var name: String? = null

     @ColumnInfo
     var category_id : Int? = null

     @ColumnInfo
     @SerializedName("view_count")
     @Expose
     var viewCount: Int? = null

     @ColumnInfo
     @SerializedName("order_count")
     @Expose
     var orderCount: Int? = null

     @ColumnInfo
     @SerializedName("shares")
     @Expose
     var shares: Int? = null

     @ColumnInfo
     @SerializedName("date_added")
     @Expose
     var dateAdded: String? = null

    @Ignore
    @SerializedName("variants")
    @Expose
    var variants: List<Variant>? = null

    @Ignore
    @SerializedName("tax")
    @Expose
    var tax: Tax? = null
}