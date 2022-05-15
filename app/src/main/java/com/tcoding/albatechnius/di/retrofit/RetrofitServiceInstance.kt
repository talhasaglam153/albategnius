package com.tcoding.albatechnius.di.retrofit

import com.tcoding.albatechnius.model.Drone
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceInstance {

    @GET("/hezarfen/api.php")
    fun getData() : Call<Drone>
}