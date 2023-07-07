package com.example.lovelocalassigment.ui.product.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrndproject.apiclient.ApiService
import com.example.kotlinrndproject.apiclient.NetworkModule
import com.example.kotlinrndproject.repository.ProductListRepository
import com.example.kotlinrndproject.repository.ProductListViewModelProvider
import com.example.lovelocalassigment.R
import com.example.lovelocalassigment.databinding.ActivityProductListBinding
import com.example.lovelocalassigment.databinding.CustomeHeaderBinding
import com.example.lovelocalassigment.ui.product.adapter.ProductListAdapter
import com.example.lovelocalassigment.ui.product.model.Product
import com.example.lovelocalassigment.ui.product.viewmodel.ProductListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductList : AppCompatActivity() {


    private var _binding: ActivityProductListBinding? = null
    private val binding get() = _binding!!

    private lateinit var _retrofit: ApiService


    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolBarView : CustomeHeaderBinding = _binding!!.toolbaView;
        toolBarView.imgLeftMenu.setBackgroundResource(R.drawable.arrow_back_icon)
        toolBarView.imgLeftMenu.setOnClickListener(View.OnClickListener {
            finish()
        });
        toolBarView.imgNotificationIcon.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "This is the dummy implementation", Toast.LENGTH_SHORT).show();
        });
        toolBarView.tvHeaderTitle.text = "Product List"

         _retrofit = NetworkModule.getRetrofitInstance()
        val viewmodel = ViewModelProvider(this, ProductListViewModelProvider(ProductListRepository(_retrofit ))).get(ProductListViewModel::class.java)




        val recyclerview = binding.recyclerview
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager
        

        var data :List<Product> = emptyList()
        var adapter = ProductListAdapter(data)

        viewmodel.productListData.observe(this, Observer { it ->
          val  data  = it.data[0].products;
                println("data item count ${data.size}")
                adapter.pListData = data
                recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()
        })




        CoroutineScope(Dispatchers.IO).launch {
            viewmodel.getProductListByCategoryList()
        }



    }



}

