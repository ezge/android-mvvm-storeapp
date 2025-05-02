package com.example.storeapp.data.model.response

data class PaymentResponseDto(
    val transactionId: String,
    val status: String,
    val timestamp: String
) {
    fun toDomain() = PaymentResponse(transactionId, status, timestamp)
}