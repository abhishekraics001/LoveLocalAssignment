package com.example.kotlinrndproject.apiclient

import com.example.lovelocalassigment.ui.product.model.ProductListResponseData
import retrofit2.http.GET


interface ApiService {

    @GET("android_2.json")
    suspend  fun getProductListByCategory(): ProductListResponseData

}