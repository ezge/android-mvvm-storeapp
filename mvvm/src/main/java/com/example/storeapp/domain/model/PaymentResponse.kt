package com.example.storeapp.domain.model

data class PaymentResponse(
    val transactionId: String,
    val status: String,
    val timestamp: String
)