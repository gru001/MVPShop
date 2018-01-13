package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.pranit.mvpshop.TABLE_PRODUCT
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_PRODUCT)
class Product {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @ColumnInfo
    @SerializedName("name")
    @Expose
    var name: String? = null

    @ColumnInfo
    @SerializedName("date_added")
    @Expose
    var dateAdded: String? = null
    /*@SerializedName("variants")
    @Expose
    var variants: List<Variant>? = null
    @SerializedName("tax")
    @Expose
    var tax: Tax? = null*/

}