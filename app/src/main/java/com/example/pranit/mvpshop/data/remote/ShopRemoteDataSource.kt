package com.example.pranit.mvpshop.data.remote

import android.util.Log
import com.example.pranit.mvpshop.MainActivity
import com.example.pranit.mvpshop.data.ShopDataSource
import com.example.pranit.mvpshop.data.models.ShopResponse
import com.example.pranit.mvpshop.network.ShopApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by pranit on 9/1/18.
 */
class ShopRemoteDataSource private constructor():ShopDataSource{

    override fun deleteAllCategories() {

    }

    override fun saveCategories(response: ShopResponse) {

    }

    override fun getCategories(callback: ShopDataSource.LoadCategoriesCallback) {
        val api = ShopApiService.create().getShopData()
        api.enqueue(object : Callback<ShopResponse> {
            override fun onResponse(call: Call<ShopResponse>, response: Response<ShopResponse>) {
                Log.i(ShopRemoteDataSource::class.java.simpleName, "onResponse "+response.body()?.categories?.size)
                callback.onCategoriesLoaded(response.body()!!)
            }

            override fun onFailure(call: Call<ShopResponse>, t: Throwable) {
                Log.e(MainActivity::class.java.simpleName, "onFailure ", t)
            }
        })
    }

    companion object {
        private var INSTANCE :ShopRemoteDataSource ?= null

        @JvmStatic fun getInstance() : ShopRemoteDataSource {
            if(INSTANCE == null) {
                synchronized(ShopRemoteDataSource::javaClass) {
                    INSTANCE = ShopRemoteDataSource()
                }
            }
            return INSTANCE!!
        }
    }
}