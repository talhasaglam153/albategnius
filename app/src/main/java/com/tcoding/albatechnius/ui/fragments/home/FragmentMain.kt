package com.tcoding.albatechnius.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMain : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root
        setupTabBar()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun setupTabBar() {
        binding.bottomNavBar.setItemSelected(R.id.product, true) // Bottomun hareket özelliğini home ile eşleştirdim demek istiyoruz..
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it){
                R.id.home -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.homeFragment)
                R.id.product -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.productFragment)
                R.id.droneinfo -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.droneInformationFragment)
                R.id.currentlocation -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.currentLocationFragment)

            }
        }
    }

}