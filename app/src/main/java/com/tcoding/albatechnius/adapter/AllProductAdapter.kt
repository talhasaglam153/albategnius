package com.tcoding.albatechnius.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.model.Product

class AllProductAdapter(var productList : List<Product>, var clickItem:(position : Int) -> Unit) : RecyclerView.Adapter<AllProductAdapter.MyCustomHolderLastView>() {



    class MyCustomHolderLastView(itemView: View, clickItem: (position: Int) -> Unit): RecyclerView.ViewHolder(itemView){
        val txtTitle = itemView.findViewById<TextView>(R.id.lastviewProductTitle)
        val productImage = itemView.findViewById<ImageView>(R.id.lastviewImage)
        val lastLinear = itemView.findViewById<LinearLayout>(R.id.lastLinear)

        init {
            itemView.setOnClickListener {
                clickItem(adapterPosition)
            }
        }

        fun bindData(product : Product, colorFirst : Int, colorSecond : Int, colorPosition: Int) {
            txtTitle.text = product.name
            if(colorPosition == 0) {
                productImage.setImageResource(product.picture)
                productImage.setBackgroundResource(colorFirst)
                lastLinear.setBackgroundResource(colorSecond)
            }else {
                productImage.setImageResource(product.picture)
                productImage.setBackgroundResource(colorSecond)
                lastLinear.setBackgroundResource(colorFirst)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomHolderLastView {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.lastview_product_item, parent, false)
        return MyCustomHolderLastView(view, clickItem)
    }

    override fun onBindViewHolder(holder: MyCustomHolderLastView, position: Int) {

        var  color1 : Int  = R.drawable.card_design2
        var color2  = R.drawable.card_design
        var colorPosition = 0
        if(position % 2 == 0) {
            colorPosition = 0
            color1 = R.drawable.card_design2
        }else {
            colorPosition = 1
            color2 = R.drawable.card_design
        }
        holder.bindData(productList!!.get(position), color1!!, color2!!, colorPosition!!)
    }

    override fun getItemCount(): Int {
        return productList.size
    }




}