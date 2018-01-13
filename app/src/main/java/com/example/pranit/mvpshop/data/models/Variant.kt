package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.Entity
import com.example.pranit.mvpshop.TABLE_VARIANT
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_VARIANT)
class Variant {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("color")
    @Expose
    var color: String? = null
    @SerializedName("size")
    @Expose
    var size: Any? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null

}