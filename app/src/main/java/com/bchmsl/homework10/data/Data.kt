package com.bchmsl.homework10.data

val productsList = listOf(
    Product(
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
    Product(
        "Women Shorts",
        D.img_women_shorts,
        null,
        29.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.BOTTOM
        )
    ),
    Product(
        "Women Printed T-shirt",
        D.img_women_tshirt_printed,
        null,
        19.99,
        listOf(
            Filters.Category.SUMMER,
            Filters.Category.TOP
        )
    ),
    Product(
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
    Product(
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

val selectedCategoriesList = mutableListOf<Filters.Category>()

