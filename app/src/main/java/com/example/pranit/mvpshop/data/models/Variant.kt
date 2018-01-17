package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.*
import com.example.pranit.mvpshop.TABLE_VARIANT
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_VARIANT, foreignKeys = [(ForeignKey(entity = Product::class,
        parentColumns = arrayOf("prod_id"),
        childColumns = arrayOf("product_id"),
        onDelete = ForeignKey.CASCADE))])
class Variant {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @ColumnInfo
    var product_id: Int? = null

    @ColumnInfo
    @SerializedName("color")
    @Expose
    var color: String? = null
    @Ignore
    @SerializedName("size")
    @Expose
    var size: Any? = null
    @ColumnInfo
    @SerializedName("price")
    @Expose
    var price: Int? = null
}