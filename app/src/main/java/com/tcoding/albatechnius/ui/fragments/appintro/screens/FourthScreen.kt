package com.tcoding.albatechnius.ui.fragments.appintro.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.databinding.FragmentFourthScreenBinding


class FourthScreen : Fragment() {
    private var _binding: FragmentFourthScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthScreenBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onResume() {
        super.onResume()
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        val prevButton = activity?.findViewById<RelativeLayout>(R.id.prevButton)
        val nextButton = activity?.findViewById<RelativeLayout>(R.id.nextButton)
        val nxtButton = activity?.findViewById<RelativeLayout>(R.id.nxtButton)


        nxtButton?.alpha = 0f
        nxtButton?.isClickable = false

        prevButton?.setOnClickListener {
            viewPager?.currentItem = 2
        }

        nextButton?.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAppIntro_to_fragmentMain)
        }

    }


}