package com.example.part3.chapter06.model

data class Sale(
    val imageUrl: String,
    val sale : String,
    val name: String,
    val badge: String? = null
) :ListItem {
    override val viewType: ViewType
        get() = ViewType.SALE
}