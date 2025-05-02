package com.example.storeapp.data.repository

import com.example.storeapp.data.remote.api.ApiService
import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.repository.OrderRepository

class OrderRepositoryImpl(private val api: ApiService): OrderRepository {
    override suspend fun placeOrder(order: Order): Boolean {
        val orderMap = mapOf(
            "items" to order.items.map { mapOf("id" to it.product.id, "quantity" to it.quantity) },
            "totalAmount" to order.totalAmount
        )
        return api.placeOrder(orderMap)
    }
}