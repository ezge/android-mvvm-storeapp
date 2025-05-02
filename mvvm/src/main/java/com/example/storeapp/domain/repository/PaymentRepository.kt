package com.example.storeapp.domain.repository

import com.example.storeapp.data.model.request.PaymentRequest
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.model.response.PaymentResponse

interface PaymentRepository {
    suspend fun processPayment(paymentRequest: PaymentRequest): Result<PaymentResponse>
    suspend fun getPaymentHistory(userId: String): Result<List<PaymentHistoryItem>>
}
