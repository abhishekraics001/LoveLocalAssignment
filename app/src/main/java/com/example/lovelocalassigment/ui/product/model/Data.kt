package com.example.lovelocalassigment.ui.product.model

data class Data(
    val id: Int,
    val is_active: Boolean,
    val location: Location,
    val name: String,
    val products: List<Product>
)