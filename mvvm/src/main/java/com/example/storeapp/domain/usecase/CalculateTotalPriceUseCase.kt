package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.CartItem
import javax.inject.Inject

class CalculateTotalPriceUseCase @Inject constructor() {
    operator fun invoke(cartItems: List<CartItem>): Double {
        return cartItems.sumOf { it.totalPrice }
    }
}