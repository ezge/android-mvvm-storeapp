package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.CartItem


interface CartRepository {
    fun getCartItems(): List<CartItem>
    fun removeFromCart(productId: Int)
}
