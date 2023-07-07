package com.example.lovelocalassigment.ui.product.model

data class Variant(
    val description: String,
    val id: Int,
    val image: String,
    val measurement: Measurement,
    val name: String,
    val price: Double,
    val units: Double
)