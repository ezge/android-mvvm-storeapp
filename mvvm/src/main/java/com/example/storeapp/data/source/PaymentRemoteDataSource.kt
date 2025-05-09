package com.example.storeapp.data.source

import com.example.storeapp.data.model.request.PaymentRequest
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.model.response.PaymentResponse

interface PaymentRemoteDataSource {
    suspend fun processPayment(paymentRequest: PaymentRequest): PaymentResponse
    suspend fun getPaymentHistory(userId: String): List<PaymentHistoryItem>
}