package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tcoding.albatechnius.databinding.FragmentDroneInformationBinding
import com.tcoding.albatechnius.di.retrofit.RetrofitServiceInstance
import com.tcoding.albatechnius.model.Drone
import com.tcoding.albatechnius.viewmodel.DroneViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://frosty-lewin.5-9-253-136.plesk.page"
@AndroidEntryPoint
class DroneInformationFragment : Fragment() {
    private var _binding: FragmentDroneInformationBinding? = null
    lateinit var viewModel : DroneViewModel
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDroneInformationBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this).get(DroneViewModel::class.java)
      //  getCurrentData()

        viewModel.loadData()
        viewModel.getObserverLiveData().observe(viewLifecycleOwner,object : Observer<Drone> {
            override fun onChanged(t: Drone?) {
                binding.textViewDroneHiz.text = t!!.speed.toString()

             //   getCurrentData()
            }

        })
        return view
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /*fun getCurrentData() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServiceInstance::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getData().awaitResponse()

            if(response.isSuccessful) {
                val data = response.body()!!

                withContext(Dispatchers.Main) {
                    // viewModel.currentNumber.value = data.hiz
                    // viewModel.currentEnlem.value = data.x
                    // viewModel.currentBoylam.value = data.y

                    viewModel.list.value = data


                }
            }
        }

    }*/


}