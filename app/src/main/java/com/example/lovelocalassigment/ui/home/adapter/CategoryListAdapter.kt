package com.example.lovelocalassigment.ui.home.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.ui.home.model.CategoryListModel
import com.example.lovelocalassigment.ui.product.ui.ProductList

class CategoryListAdapter(private val cList: List<CategoryListModel>, private val context: Context) : RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {



    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view  that is used to hold list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_list_row_item, parent, false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = cList[position]

        holder.imgCategoryImage.setImageResource(itemsViewModel.categoryImage)
        holder.tvCategoryName.text = itemsViewModel.categoryName
        holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ProductList::class.java)
            context.startActivity(intent);
        })
    }



    // return the number of the items in the list
    override fun getItemCount(): Int {
        return cList.size
    }




    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgCategoryImage: ImageView = itemView.findViewById(R.id.imgCategoryImage)
        val tvCategoryName: TextView = itemView.findViewById(R.id.tvCategoryName)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }
}
