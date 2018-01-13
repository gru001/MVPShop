package com.example.pranit.mvpshop.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.pranit.mvpshop.TABLE_TAX
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = TABLE_TAX)
class Tax {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("value")
    @Expose
    var value: Float? = null

}