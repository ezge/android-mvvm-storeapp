package com.example.storeapp.data.remote.dto

data class PaymentResponse(
    val transactionId: String,
    val amountPaid: Double,
    val paymentDate: String,
    val paymentStatus: String
)

fun PaymentResponse.toDomain(): PaymentHistoryItem {
    return PaymentHistoryItem(
        transactionId = transactionId,
        amount = amountPaid,
        date = paymentDate,
        status = paymentStatus
    )
}
