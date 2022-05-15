package com.tcoding.albatechnius.di.retrofit

import androidx.lifecycle.MutableLiveData
import com.tcoding.albatechnius.model.Drone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject



class RetrofitRepository @Inject constructor(private val retrofitServiceInstance: RetrofitServiceInstance) {


    fun getDroneInfo(liveData: MutableLiveData<Drone>): MutableLiveData<Drone> {
        retrofitServiceInstance.getData().enqueue(object : Callback<Drone>{
            override fun onResponse(call: Call<Drone>, response: Response<Drone>) {
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<Drone>, t: Throwable) {
                liveData.postValue(null)
            }

        })
        return liveData
    }



}