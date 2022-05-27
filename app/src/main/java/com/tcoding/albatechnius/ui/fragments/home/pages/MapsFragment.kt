package com.tcoding.albatechnius.ui.fragments.home.pages

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tcoding.albatechnius.BLL.BLL
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.di.retrofit.RetrofitServiceInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

class MapsFragment : Fragment() {


    private val callback = OnMapReadyCallback { googleMap ->
        if(isOnline(requireContext())) {
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

                        val drone = LatLng(data.x.toDouble(), data.y.toDouble())
                        println(data.toString())
                        googleMap.addMarker(MarkerOptions().position(drone).title("Marker on Drone"))
                        googleMap.moveCamera(CameraUpdateFactory.newLatLng(drone))
                        googleMap.animateCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                drone, 20.0f))

                    }
                }
            }
        }else {
            Toast.makeText(requireContext(), "İnternetinizi Kontrol Ediniz", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}