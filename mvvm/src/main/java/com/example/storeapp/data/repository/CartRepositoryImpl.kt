package com.example.storeapp.data.repository

import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.repository.CartRepository


class CartRepositoryImpl : CartRepository {
    private val cartItems = mutableListOf<CartItem>() // Normally, from a database

    override fun getCartItems(): List<CartItem> = cartItems

    override fun removeFromCart(productId: Int) {
        cartItems.removeAll { it.product.id == productId }
    }
}
