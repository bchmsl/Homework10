package com.bchmsl.homework10.data

data class Product(
    val title: String,
    val image: Int,
    val oldPrice: Double? = null,
    val price: Double,
    val category: List<Filters.Category>
)
