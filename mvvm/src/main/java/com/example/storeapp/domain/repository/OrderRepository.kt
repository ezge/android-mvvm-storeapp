package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.Order

interface OrderRepository {
    suspend fun placeOrder(order: Order): Boolean
}