package com.tcoding.albatechnius.ui.fragments.home.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.tcoding.albatechnius.BLL.BLL
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.adapter.ProductAdapter
import com.tcoding.albatechnius.adapter.ProductAllAdapter
import com.tcoding.albatechnius.databinding.FragmentProductBinding
import com.tcoding.albatechnius.model.Product
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    lateinit var productListe : ArrayList<Product>
    lateinit var allProductList : ArrayList<Product>
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!
    lateinit var productAdapter : ProductAdapter
    lateinit var productAllAdapterAdapter : ProductAllAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.seeAll.setOnClickListener {
            findNavController().navigate(R.id.action_productFragment_to_allProductsFragment)
        }
        initRecyclerView()
        return view
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initRecyclerView() {
        var lmHorizontal = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        var lmVertical = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

      /*  binding.rvPopularMovies.layoutManager = lmHorizontal
        binding.rvRecentMovies.layoutManager = lmVertical*/
        binding.rvPopularPlants.layoutManager = lmHorizontal
        binding.rvAllPlants.layoutManager = lmVertical
        allProductList = ArrayList<Product>()
        allProductList = BLL.getAllProduct()
        productListe = ArrayList<Product>()
        productListe = BLL.getPopularProduct()

        productAllAdapterAdapter = ProductAllAdapter(allProductList)
        productAdapter = ProductAdapter(true,productListe)

       /* binding.rvRecentMovies.adapter = recentMovieAdapter
        binding.rvPopularMovies.adapter = movieAdapter*/

        binding.rvPopularPlants.adapter = productAdapter
        binding.rvAllPlants.adapter = productAllAdapterAdapter

    }


}