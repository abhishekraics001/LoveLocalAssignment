package com.example.kotlinrndproject.apiclient

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object NetworkModule {
    fun getRetrofitInstance(): ApiService {
        val retrofit: Retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://generic-bulk-upload.s3.amazonaws.com/")
            .build()
        return retrofit.create(ApiService::class.java);
    }
}
