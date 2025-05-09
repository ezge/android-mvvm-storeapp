package com.example.storeapp.data.source

import com.example.storeapp.data.model.response.PaymentHistoryItem

interface PaymentLocalDataSource {
    suspend fun savePaymentHistory(items: List<PaymentHistoryItem>)
    suspend fun getCachedPaymentHistory(userId: String): List<PaymentHistoryItem>
}