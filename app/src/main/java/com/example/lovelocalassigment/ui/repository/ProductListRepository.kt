package com.example.kotlinrndproject.repository

import com.example.kotlinrndproject.apiclient.ApiService
import com.example.lovelocalassigment.ui.product.model.ProductListResponseData

class ProductListRepository constructor(private val apiService: ApiService) {

   suspend  fun getUsers(): ProductListResponseData {
        var isOnlineDataSynck = false



        // Make a Retrofit API call to fetch users
        if(isOnlineDataSynck){
        }else{
            //userListData = apiService.getUsers();
        }
        return  apiService.getProductListByCategory();
    }


}


