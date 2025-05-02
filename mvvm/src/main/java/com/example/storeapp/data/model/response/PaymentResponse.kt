package com.example.storeapp.data.model.response

data class PaymentResponse(
    val transactionId: String,
    val status: String,
    val timestamp: String
)