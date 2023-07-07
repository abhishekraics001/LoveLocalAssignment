package com.example.kotlinrndproject.repository

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lovelocalassigment.ui.product.viewmodel.ProductListViewModel


class ProductListViewModelProvider constructor(private val repository: ProductListRepository): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ProductListViewModel::class.java)) {
            ProductListViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}
