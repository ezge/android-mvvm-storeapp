package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.repository.OrderRepository

class PlaceOrderUseCase(private val orderRepository: OrderRepository) {
    suspend operator fun invoke(order: Order): Boolean {
        return orderRepository.placeOrder(order)
    }
}