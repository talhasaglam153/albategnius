package com.tcoding.albatechnius.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcoding.albatechnius.R
import com.tcoding.albatechnius.model.Product

class PopularProductAdapter(private val isProductFragment : Boolean = true, var productList : List<Product>) : RecyclerView.Adapter<PopularProductAdapter.MyCustomHolder>() {


    fun setList(productList : List<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    class MyCustomHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitle = itemView.findViewById<TextView>(R.id.productTitle)
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)

        fun bindData(product : Product, color : Int) {

            txtTitle.text = product.name
            productImage.setImageResource(product.picture)
            productImage.setBackgroundResource(color)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCustomHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return MyCustomHolder(view)
    }

    override fun onBindViewHolder(holder: MyCustomHolder, position: Int) {
        var  color = R.color.purple_200
        if(position % 2 == 0) {
            color = R.color.purple_200
        }else {
            color = R.color.teal_200
        }
       holder.bindData(productList!!.get(position), color)
    }

    override fun getItemCount(): Int {
        if(productList == null) {
            return 0
        }else if(isProductFragment){
            return 3
        }else
            return productList!!.size
    }

}