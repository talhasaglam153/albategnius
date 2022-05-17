package com.tcoding.albatechnius.ui.fragments.home.pages

import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
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

        val drone = LatLng(37.17239185, 39.003394)
        googleMap.addMarker(MarkerOptions().position(drone).title("Marker on Drone"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(drone))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                drone, 60.0f))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}