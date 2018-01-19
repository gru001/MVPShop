package com.example.pranit.mvpshop

import android.content.Context
import com.example.pranit.mvpshop.data.ShopRepository
import com.example.pranit.mvpshop.data.local.ShopDatabase
import com.example.pranit.mvpshop.data.local.ShopLocalDataSource
import com.example.pranit.mvpshop.data.remote.ShopRemoteDataSource
import com.example.pranit.mvpshop.util.AppExecutors

/**
 * Created by pranit on 19/1/18.
 */
object Injection {
    fun provideTasksRepository(context: Context): ShopRepository {
        val database = ShopDatabase.getInstance(context)
        return ShopRepository.getInstance(ShopLocalDataSource.getInstance(AppExecutors(),
                database.categoryDao(), database.productDao(), database.variantDao()), ShopRemoteDataSource.getInstance())
    }
}