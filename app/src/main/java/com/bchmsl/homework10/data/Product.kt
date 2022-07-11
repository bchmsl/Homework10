package com.bchmsl.homework10.data

import com.bchmsl.homework10.R

typealias D = R.drawable

data class Product(
    val title: String,
    val image: Int,
    val oldPrice: Double? = null,
    val price: Double,
    val category: List<Filters.Category>
)
