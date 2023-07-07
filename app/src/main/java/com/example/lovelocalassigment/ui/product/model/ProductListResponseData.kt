package com.example.lovelocalassigment.ui.product.model

data class ProductListResponseData(
    val count: Int,
    val `data`: List<Data>,
    val next: String,
    val prev: String,
    val success: Boolean
)