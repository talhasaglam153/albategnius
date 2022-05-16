package com.tcoding.albatechnius.ui.fragments.appintro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcoding.albatechnius.adapter.ViewPagerAdapter
import com.tcoding.albatechnius.databinding.FragmentAppIntroBinding
import com.tcoding.albatechnius.ui.fragments.appintro.screens.*


class FragmentAppIntro : Fragment() {
    private var _binding: FragmentAppIntroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppIntroBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen(),
            FourthScreen()
        )

        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}