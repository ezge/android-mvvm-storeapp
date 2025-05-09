package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.repository.CartRepository
import javax.inject.Inject


class GetCartItemsUseCase @Inject constructor(private val cartRepository: CartRepository) {
    operator fun invoke(): List<CartItem> {
        return cartRepository.getCartItems()
    }
}
