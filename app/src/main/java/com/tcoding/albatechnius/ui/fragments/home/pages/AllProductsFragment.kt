package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcoding.albatechnius.BLL.BLL
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.adapter.AllProductAdapter
import com.tcoding.albatechnius.adapter.PopularProductAdapter
import com.tcoding.albatechnius.adapter.HomeProductAdapter
import com.tcoding.albatechnius.databinding.FragmentAllProductsBinding
import com.tcoding.albatechnius.databinding.FragmentProductBinding
import com.tcoding.albatechnius.model.Product


class AllProductsFragment : Fragment() {
    private var _binding: FragmentAllProductsBinding? = null
    //lateinit var viewModel : DroneViewModel
    private val binding get() = _binding!!
    lateinit var allProductList : ArrayList<Product>
    lateinit var allProductAdapter : AllProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAllProductsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()

    }

    fun initRecyclerView() {

        var lmVertical = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvAllProducts.layoutManager = lmVertical
        allProductList = ArrayList<Product>()

        allProductList = BLL.getAllProduct()
        allProductAdapter = AllProductAdapter(allProductList, ::clickItem)
        binding.rvAllProducts.adapter = allProductAdapter
    }

    fun clickItem(position : Int) {
        Toast.makeText(requireContext(), "${allProductList.get(position).name} MODEL TANIMA ETKİNLEŞTİRİLDİ", Toast.LENGTH_SHORT).show()
    }

}