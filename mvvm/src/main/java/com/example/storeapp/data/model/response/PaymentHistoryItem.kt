package com.example.storeapp.data.model.response

data class PaymentHistoryItem(
    val transactionId: String,
    val amount: Double,
    val date: String,
    val status: String
)