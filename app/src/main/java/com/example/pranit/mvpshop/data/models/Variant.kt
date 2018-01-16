package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.example.pranit.mvpshop.TABLE_VARIANT
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_VARIANT, foreignKeys = arrayOf(ForeignKey(entity = Product::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("product_id"),
        onDelete = ForeignKey.CASCADE)))
class Variant {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @ColumnInfo
    @SerializedName("color")
    @Expose
    var color: String? = null
    @ColumnInfo
    @SerializedName("size")
    @Expose
    var size: Any? = null
    @ColumnInfo
    @SerializedName("price")
    @Expose
    var price: Int? = null

    @ColumnInfo
    var product_id: Int? = null

}