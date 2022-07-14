package com.bchmsl.homework10.data

import com.bchmsl.homework10.R

typealias D = R.drawable

val productsList = listOf(
    Product(
        1,
        "Men Cargo Joggers",
        D.img_men_cargo_joggers_1,
        59.99,
        39.99,
        listOf(
            Filters.Category.BOTTOM,
            Filters.Category.ALL_SEASON,
            Filters.Category.WINTER,
            Filters.Category.SUMMER,
            Filters.Category.SALE
        )
    ),
    Product(
        2,
        "Men Cargo Joggers",
        D.img_men_cargo_joggers_2,
        null,
        49.99,
        listOf(
            Filters.Category.ALL_SEASON,
            Filters.Category.WINTER,
            Filters.Category.SUMMER,
            Filters.Category.BOTTOM
        )
    ),
    Product(
        3,
        "Men Chino Shorts",
        D.img_men_chino_shorts,
        39.99,
        29.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.SALE,
            Filters.Category.BOTTOM
        )
    ),
    Product(
        4,
        "Men Slides",
        D.img_men_slides,
        29.99,
        9.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.SALE,
            Filters.Category.FOOTWEAR
        )
    ),
    Product(
        5,
        "Men Slim Fit Shirt",
        D.img_men_slim_fit_shirt,
        null,
        19.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.TOP
        )
    ),
    Product(
        6,
        "Men Trainers",
        D.img_men_trainers,
        109.99,
        69.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.FOOTWEAR,
            Filters.Category.SALE
        )
    ),
    Product(
        7,
        "Women Baggy Jeans",
        D.img_women_baggy_jeans,
        null,
        39.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.WINTER,
            Filters.Category.ALL_SEASON,
            Filters.Category.TOP
        )
    ),
    Product(
        8,
        "Women Bermuda Shorts",
        D.img_women_bermuda_shorts,
        null,
        29.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.BOTTOM
        )
    ),
    Product(
        9,
        "Women Ribbed Top",
        D.img_women_ribbed_top,
        29.99,
        19.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.TOP,
            Filters.Category.SALE
        )
    ),
    Product(
        10,
        "Women Tennis Shoes",
        D.img_women_shoes_tennis,
        59.99,
        39.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.FOOTWEAR,
            Filters.Category.SALE
        )
    ),
    Product(11,
        "Women Shorts",
        D.img_women_shorts,
        null,
        29.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.BOTTOM
        )
    ),
    Product(12,
        "Women Printed T-shirt",
        D.img_women_tshirt_printed,
        null,
        19.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.TOP
        )
    ),
    Product(13,
        "Women White Trainers",
        D.img_women_white_trainers,
        null,
        49.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.WINTER,
            Filters.Category.ALL_SEASON,
            Filters.Category.FOOTWEAR
        )
    ),
    Product(14,
        "Women Cotton T-Shirt",
        D.imt_women_cotton_tshirt,
        39.99,
        29.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.TOP,
            Filters.Category.SALE
        )
    )

)

var selectedProductsList = mutableListOf<Product>()

var selectedCategoriesList = mutableListOf<Filters.Category>()

