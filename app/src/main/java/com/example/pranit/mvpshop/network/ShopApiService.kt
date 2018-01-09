package com.example.pranit.mvpshop.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by pranit on 9/1/18.
 */
interface ShopApiService {



    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): ShopApiService {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.github.com/")
                    .build()

            return retrofit.create(ShopApiService::class.java);
        }
    }
}