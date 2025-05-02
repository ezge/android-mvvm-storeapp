package com.example.storeapp.domain.model

data class Order(
    val items: List<CartItem>
) {
    val totalAmount: Double
        get() = items.sumOf { it.totalPrice }
}
