package com.tcoding.albatechnius.ui.fragments.home.pages

import android.content.Context
import android.media.MediaPlayer
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tcoding.albatechnius.R
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


@AndroidEntryPoint
class DroneInformationFragment : Fragment() {
    private var _binding: FragmentDroneInformationBinding? = null
    private val binding get() = _binding!!

    val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(DroneViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDroneInformationBinding.inflate(inflater, container, false)
        val view = binding.root
        if(isOnline(requireContext())) {
            getCurrentData()
        }else {
            Toast.makeText(requireContext(), "İnternetinizi kontrol ediniz", Toast.LENGTH_SHORT).show()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        var mediaPlayer = MediaPlayer.create(requireContext(), R.raw.beep)
        viewModel.getObserverLiveData().observe(viewLifecycleOwner,object : Observer<Drone> {
            override fun onChanged(t: Drone?) {

                binding.textViewDroneHiz.text = t!!.hiz.toString()
                binding.textViewBatteryState.text = t!!.battery.toString()+"V"
                binding.textViewDroneMode.text = t!!.mode
                binding.textViewLang.text = t!!.x.toString()
                binding.textViewLong.text = t!!.y.toString()
                binding.textH.text = t!!.h.toString() + "m"


                if(t!!.flag == 1) {
                    binding.textViewFlag.visibility = View.VISIBLE
                    mediaPlayer.start()


                }else {
                    binding.textViewFlag.visibility = View.INVISIBLE
                    mediaPlayer.stop()
                    mediaPlayer = MediaPlayer.create(requireContext(), R.raw.beep)
                }
                getCurrentData()
            }
        })
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        }
        return false
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getCurrentData() {
        val api = Retrofit.Builder()
            .baseUrl("https://frosty-lewin.5-9-253-136.plesk.page/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitServiceInstance::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = api.getData().awaitResponse()

            if(response.isSuccessful) {
                val data = response.body()!!

                withContext(Dispatchers.Main) {
                    viewModel.list.value = data
                }
            }
        }

    }


}