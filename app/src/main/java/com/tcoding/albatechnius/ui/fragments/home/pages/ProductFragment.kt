package com.tcoding.albatechnius.ui.fragments.home.pages

import android.content.Intent
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
import com.tcoding.albatechnius.adapter.PopularProductAdapter
import com.tcoding.albatechnius.adapter.HomeProductAdapter
import com.tcoding.albatechnius.databinding.FragmentProductBinding
import com.tcoding.albatechnius.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    lateinit var productListe : ArrayList<Product>
    lateinit var allProductList : ArrayList<Product>
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    lateinit var popularProductAdapter : PopularProductAdapter
    lateinit var homeProductAdapterAdapter : HomeProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        seeAll()

        return view
    }


    fun seeAll() {
        binding.seeAll.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_allProductsFragment)
        }
    }

    override fun onResume() {
        super.onResume()
        initRecyclerView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initRecyclerView() {
        var lmHorizontal = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var lmVertical = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        binding.rvPopularPlants.layoutManager = lmHorizontal
        binding.rvAllPlants.layoutManager = lmVertical
        allProductList = ArrayList<Product>()
        allProductList = BLL.getAllProductHome()
        productListe = ArrayList<Product>()
        productListe = BLL.getPopularProduct()

        homeProductAdapterAdapter = HomeProductAdapter(allProductList, ::clickItem)
        popularProductAdapter = PopularProductAdapter(true,productListe)

        binding.rvPopularPlants.adapter = popularProductAdapter
        binding.rvAllPlants.adapter = homeProductAdapterAdapter

    }

    fun clickItem(position : Int) {
        /*val intent = Intent(activity, Deneme::class.java)
        intent.putExtra("product",allProductList.get(position))
        startActivity(intent)*/
        Toast.makeText(requireContext(), "${allProductList.get(position).name} MODEL TANIMA AKTİFLEŞTİRİLDİ", Toast.LENGTH_SHORT).show()
    }


}