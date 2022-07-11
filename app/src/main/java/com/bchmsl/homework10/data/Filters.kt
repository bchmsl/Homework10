package com.bchmsl.homework10.data

class Filters {

    enum class Category(val categoryName: String, var selected: Boolean) {
        SALE("SALE", false),
        TOP("Top", false),
        BOTTOM("Bottom", false),
        FOOTWEAR("Footwear", false),
        SUMMER("Summer", false),
        WINTER("Winter", false),
        ALL_SEASON("All Seasons", false),

    }
}
