package com.tcoding.albatechnius.BLL

import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.model.Product

object BLL {

    private val productList = ArrayList<Product>()
    private val popularProduct = ArrayList<Product>()

    fun createProduct() {
        productList.add(Product(1,"Domates", R.drawable.domates))
        productList.add(Product(2,"Ayçiçeği", R.drawable.aycicegi))
        productList.add(Product(3,"Pamuk", R.drawable.pamuk))
        productList.add(Product(4,"Karpuz", R.drawable.karpuz))
        productList.add(Product(5,"Ayçiçeği", R.drawable.aycicegi))
        productList.add(Product(6,"Pamuk", R.drawable.pamuk))
        productList.add(Product(7,"Domates", R.drawable.domates))
        productList.add(Product(8,"Ayçiçeği", R.drawable.aycicegi))
        productList.add(Product(9,"Karpuz", R.drawable.karpuz))
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

    fun getAllProduct() : ArrayList<Product> {
        createProduct()
        return productList
    }



}