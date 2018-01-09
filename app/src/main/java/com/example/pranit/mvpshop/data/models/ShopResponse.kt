package com.example.pranit.mvpshop.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ShopResponse {

    @SerializedName("categories")
    @Expose
    var categories: List<Category>? = null
    @SerializedName("rankings")
    @Expose
    var rankings: List<Ranking>? = null

}