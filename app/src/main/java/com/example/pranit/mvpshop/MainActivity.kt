package com.example.pranit.mvpshop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.pranit.mvpshop.data.local.ShopDatabase
import com.example.pranit.mvpshop.data.models.ShopResponse
import com.example.pranit.mvpshop.network.ShopApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var api = ShopApiService.create().getShopData()
        api.enqueue(object : Callback<ShopResponse> {
            override fun onResponse(call: Call<ShopResponse>, response: Response<ShopResponse>) {
                Log.i(MainActivity::class.java.simpleName, "onResponse "+response.body()?.categories?.size)

                val database = ShopDatabase.getInstance(this@MainActivity)

                Thread {
                    kotlin.run {
                        for (category in response.body()?.categories!!) {
                            database.categoryDao().insertTask(category)
                        }
                    }
                }.start()

            }

            override fun onFailure(call: Call<ShopResponse>, t: Throwable) {
                Log.e(MainActivity::class.java.simpleName, "onFailure ", t)
            }
        })

    }
}
