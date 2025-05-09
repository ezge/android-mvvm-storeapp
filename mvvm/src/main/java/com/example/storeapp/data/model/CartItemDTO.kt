package com.example.storeapp.data.model

import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.model.Product


data class CartItemDto(
    val productId: Int,
    val productName: String,
    val productPrice: Double,
    //val productImageUrl: String,
    val quantity: Int
) {
    fun toDomainModel(): CartItem {
        return CartItem(
            product = Product(
                id = productId,
                name = productName,
                price = productPrice,
                //imageUrl = productImageUrl
            ),
            quantity = quantity
        )
    }

    companion object {
        fun fromDomain(cartItem: CartItem): CartItemDto {
            return CartItemDto(
                productId = cartItem.product.id,
                productName = cartItem.product.name,
                productPrice = cartItem.product.price,
               // productImageUrl = cartItem.product.imageUrl,
                quantity = cartItem.quantity
            )
        }
    }
}