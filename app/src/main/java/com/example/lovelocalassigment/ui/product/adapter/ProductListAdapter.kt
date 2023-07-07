package com.example.lovelocalassigment.ui.product.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.ui.product.model.Product

class ProductListAdapter(private val plist: List<Product>, ) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {


    lateinit var context: Context
    var pListData: List<Product> = plist





    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view  that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_list_row_item, parent, false)

        context = parent.context
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemData = pListData[position]
        holder.tvProductName.text =  itemData.name
        holder.tvProductActualPrice.text = "${itemData.variants.get(0).price} RS"
        Glide.with(context).load(itemData.image).into(holder.pImageName);

    }




    // return the number of the items in the list
    override fun getItemCount(): Int {
        return pListData.size
    }




    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val pImageName: ImageView = itemView.findViewById(R.id.pImageName)
        val tvProductActualPrice: TextView = itemView.findViewById(R.id.tvProductActualPrice)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
    }
}
