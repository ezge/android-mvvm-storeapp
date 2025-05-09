package com.example.storeapp.data.remote

import com.example.storeapp.data.model.request.PaymentRequest
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.model.response.PaymentResponse
import com.example.storeapp.data.source.PaymentRemoteDataSource

class PaymentRemoteDataSourceImpl(
    private val apiService: PaymentApiService
) : PaymentRemoteDataSource {

    override suspend fun processPayment(paymentRequest: PaymentRequest): PaymentResponse {
        return apiService.processPayment(paymentRequest)
    }

    override suspend fun getPaymentHistory(userId: String): List<PaymentHistoryItem> {
        return apiService.getPaymentHistory(userId)
    }
}
