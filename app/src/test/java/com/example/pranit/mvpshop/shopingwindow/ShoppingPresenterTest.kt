package com.example.pranit.mvpshop.shopingwindow

import com.example.pranit.mvpshop.capture
import com.example.pranit.mvpshop.data.ShopDataSource
import com.example.pranit.mvpshop.data.ShopRepository
import com.example.pranit.mvpshop.data.models.Category
import com.google.common.collect.Lists
import org.junit.Before
import org.junit.Test
import org.mockito.*

/**
 * Created by pranit on 2/2/18.
 */
class ShoppingPresenterTest {
    @Mock private lateinit var shopRepository : ShopRepository
    @Mock private lateinit var shopView : ShoppingContract.View
    @Captor private lateinit var loadCategoriesCallbackCAptor: ArgumentCaptor<ShopDataSource.LoadCategoriesCallback>

    private lateinit var shoppingPresenter: ShoppingPresenter
    private lateinit var categories : MutableList<Category>

    @Before fun setupShoppingPresenter() {
        MockitoAnnotations.initMocks(this)
        shoppingPresenter = ShoppingPresenter(shopRepository, shopView)

        categories = Lists.newArrayList(Category().apply { id = 1
        name = "Shoes" }, Category().apply { id = 2
        name = "Clothes"})
    }

    @Test fun test_whenloadCategories_reutrnslistofcategories() {
        shoppingPresenter.start()
        Mockito.verify(shopRepository).getCategories(capture(loadCategoriesCallbackCAptor))
        loadCategoriesCallbackCAptor.value.onCategoriesLoaded(categories)
        Mockito.verify(shopView).onCategoriesLoaded(ArrayList(categories))
    }

}