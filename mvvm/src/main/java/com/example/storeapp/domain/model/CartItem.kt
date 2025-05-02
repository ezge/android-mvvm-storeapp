package com.example.storeapp.domain.model

import com.example.storeapp.domain.model.Product

data class CartItem(val product: Product,
                    val quantity: Int){
    val totalPrice: Double
        get() = product.price * quantity
}
