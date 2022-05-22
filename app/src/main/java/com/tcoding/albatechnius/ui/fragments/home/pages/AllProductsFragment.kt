package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.databinding.FragmentAllProductsBinding
import com.tcoding.albatechnius.databinding.FragmentDroneInformationBinding
import com.tcoding.albatechnius.model.Product


class AllProductsFragment : Fragment() {
    private var _binding: FragmentAllProductsBinding? = null
    //lateinit var viewModel : DroneViewModel
    private val binding get() = _binding!!

    lateinit var allProductList : ArrayList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllProductsBinding.inflate(inflater, container, false)
        val view = binding.root
        return inflater.inflate(R.layout.fragment_all_products, container, false)
    }

    fun initRecyclerView() {

    }

}