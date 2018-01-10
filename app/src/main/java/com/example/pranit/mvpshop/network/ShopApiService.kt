package com.example.pranit.mvpshop.network

import com.example.pranit.mvpshop.data.models.ShopResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by pranit on 9/1/18.
 */
interface ShopApiService {

    @GET("json")
    fun getShopData() : Call<ShopResponse>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): ShopApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://stark-spire-93433.herokuapp.com/")
                    .build()

            return retrofit.create(ShopApiService::class.java)
        }
    }
}