package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.repository.CartRepository

class RemoveFromCartUseCase(private val cartRepository: CartRepository) {
    operator fun invoke(productId: Int) {
        cartRepository.removeFromCart(productId)
    }
}