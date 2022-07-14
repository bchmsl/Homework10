package com.bchmsl.homework10.data

import java.io.Serializable

data class Product(
    val id: Int,
    val title: String,
    val image: Int,
    val oldPrice: Double? = null,
    val price: Double,
    val category: List<Filters.Category>
) : Serializable
