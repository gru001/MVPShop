package com.example.pranit.mvpshop.data.local

import android.support.annotation.VisibleForTesting
import com.example.pranit.mvpshop.data.ShopDataSource
import com.example.pranit.mvpshop.data.models.ShopResponse
import com.example.pranit.mvpshop.util.AppExecutors

/**
 * Created by pranit on 9/1/18.
 */
class ShopLocalDataSource private constructor(val appExecutors: AppExecutors, val categoryDao: CategoryDao, val productDao: ProductDao, val variantDao: VariantDao) : ShopDataSource {

    override fun deleteAllCategories() {
        appExecutors.diskIO.execute{
            categoryDao.deleteProducts()
        }
    }

    override fun getCategories(callback: ShopDataSource.LoadCategoriesCallback) {
        appExecutors.diskIO.execute {
            callback.onCategoriesLoaded(categoryDao.getCategories())
        }
    }

    override fun saveCategories(response: ShopResponse) {
        appExecutors.diskIO.execute{
            for (category in response.categories!!) {
                categoryDao.insertCategory(category)
                for (product in category.products!!) {
                    product.category_id = category.id
                    productDao.insertProduct(product)
                    for (variant in product.variants!!) {
                        variant.product_id = product.prod_id
                        variantDao.insertVariant(variant)
                    }
                }
            }

            for(ranking in response.rankings!!) {
                for (product in ranking.products) {
                    productDao.updateRanking(product.viewCount!!, product.orderCount!!, product.shares!!, product.id!!)
                }
            }
        }
    }

    companion object {
        private var INSTANCE: ShopLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, categoryDao: CategoryDao, productDao: ProductDao, variantDao: VariantDao): ShopLocalDataSource {
            if (INSTANCE == null) {
                synchronized(ShopLocalDataSource::javaClass) {
                    INSTANCE = ShopLocalDataSource(appExecutors, categoryDao, productDao , variantDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }
    }

}