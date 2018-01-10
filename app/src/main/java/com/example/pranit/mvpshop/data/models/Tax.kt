package com.example.pranit.mvpshop.data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Tax {

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("value")
    @Expose
    var value: Float? = null

}