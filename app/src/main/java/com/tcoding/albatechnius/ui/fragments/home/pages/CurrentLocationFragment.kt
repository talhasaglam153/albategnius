package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcoding.albatechnius.databinding.FragmentCurrentLocationBinding
import com.tcoding.albatechnius.databinding.FragmentProductBinding


class CurrentLocationFragment : Fragment() {

    private var _binding: FragmentCurrentLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCurrentLocationBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}