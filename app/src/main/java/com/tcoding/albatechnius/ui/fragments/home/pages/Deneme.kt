package com.tcoding.albatechnius.ui.fragments.home.pages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.databinding.ActivityDenemeBinding
import com.tcoding.albatechnius.model.Product

class Deneme : AppCompatActivity() {
    lateinit var binding : ActivityDenemeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDenemeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var product = intent.getSerializableExtra("product") as Product
        binding.textViewProduct.setText(product.name)

    }
}