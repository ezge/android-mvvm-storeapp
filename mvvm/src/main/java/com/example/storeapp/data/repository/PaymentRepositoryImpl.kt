package com.example.storeapp.data.repository

import com.example.storeapp.data.model.request.PaymentRequest
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.model.response.PaymentResponse
import com.example.storeapp.data.source.PaymentRemoteDataSource
import com.example.storeapp.domain.repository.PaymentRepository

class PaymentRepositoryImpl(
    private val paymentRemoteDataSource: PaymentRemoteDataSource,
    private val paymentLocalDataSource: PaymentLocalDataSource? = null // optional
) : PaymentRepository {

    override suspend fun processPayment(paymentRequest: PaymentRequest): Result<PaymentResponse> {
        return try {
            val response = paymentRemoteDataSource.processPayment(paymentRequest)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPaymentHistory(userId: String): Result<List<PaymentHistoryItem>> {
        return try {
            val history = paymentRemoteDataSource.getPaymentHistory(userId)
            Result.success(history)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
