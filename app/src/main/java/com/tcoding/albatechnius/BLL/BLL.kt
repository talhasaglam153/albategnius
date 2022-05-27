package com.tcoding.albatechnius.BLL

import android.util.Log
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.di.retrofit.RetrofitServiceInstance
import com.tcoding.albatechnius.model.Drone
import com.tcoding.albatechnius.model.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

object BLL {

    private val productList = ArrayList<Product>()
    private val popularProduct = ArrayList<Product>()

    fun createProduct() {
        productList.add(Product(1,"Domates", R.drawable.domates))
        productList.add(Product(2,"Ayçiçeği", R.drawable.aycicegi))
        productList.add(Product(3,"Pamuk", R.drawable.pamuk))
        productList.add(Product(4,"Karpuz", R.drawable.karpuz))
        productList.add(Product(5,"Salatalık", R.drawable.salatalik))
        productList.add(Product(6,"Kavun", R.drawable.kavun))
        productList.add(Product(7,"Marul", R.drawable.marul))
    }

    fun createPopularProduct() {
        popularProduct.add(Product(1,"Domates", R.drawable.domates))
        popularProduct.add(Product(1,"Ayçiçeği", R.drawable.aycicegi))
        popularProduct.add(Product(1,"Karpuz", R.drawable.karpuz))
    }

    fun getPopularProduct() : ArrayList<Product> {
        createPopularProduct()
        return popularProduct
    }

    fun getAllProductHome() : ArrayList<Product> {
        createProduct()
        return productList
    }

    fun getAllProduct() : ArrayList<Product> {
        return productList
    }

    fun clearProductList() {
        productList.clear()
    }

}