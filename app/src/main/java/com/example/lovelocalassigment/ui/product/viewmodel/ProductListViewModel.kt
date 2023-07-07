package com.example.lovelocalassigment.ui.product.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinrndproject.repository.ProductListRepository
import com.example.lovelocalassigment.ui.product.model.ProductListResponseData
import kotlinx.coroutines.launch


class ProductListViewModel  constructor(private val userRepository: ProductListRepository) : ViewModel() {

    private val _productListData = MutableLiveData<ProductListResponseData>()
    val productListData: LiveData<ProductListResponseData> = _productListData

    fun getProductListByCategoryList() {
        try{
            viewModelScope.launch {
                val users = userRepository.getUsers()
                _productListData.value = users
            }
        }catch (e: Exception){
            e.printStackTrace()
        }
    }



}