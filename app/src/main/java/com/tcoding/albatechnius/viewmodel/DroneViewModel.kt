package com.tcoding.albatechnius.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tcoding.albatechnius.di.retrofit.RetrofitRepository
import com.tcoding.albatechnius.model.Drone
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DroneViewModel @Inject constructor(private val repository: RetrofitRepository): ViewModel() {
    var list: MutableLiveData<Drone>

    init {
        list = MutableLiveData()
    }
    fun getObserverLiveData() : MutableLiveData<Drone> {
        return list
    }

    fun loadData(): MutableLiveData<Drone> {
        return repository.getDroneInfo(list)
    }



}