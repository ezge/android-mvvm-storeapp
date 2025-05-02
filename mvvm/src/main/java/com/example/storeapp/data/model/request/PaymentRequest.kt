package com.example.storeapp.data.model.request

data class PaymentRequest(
    val userId: String,
    val amount: Double,
    val paymentMethod: String
)