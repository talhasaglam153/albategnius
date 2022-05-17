package com.tcoding.albatechnius.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcoding.albatechnius.model.Drone

class MyViewModel: ViewModel() {

    var list: MutableLiveData<Drone>

    init {
        list = MutableLiveData()
    }


    fun getObserverLiveData() : MutableLiveData<Drone> {
        return list
    }




}