package com.example.storeapp.data.local

import com.example.storeapp.data.local.dao.PaymentDao
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.source.PaymentLocalDataSource

class PaymentLocalDataSourceImpl(private val paymentDao: PaymentDao) : PaymentLocalDataSource {

    override suspend fun savePaymentHistory(items: List<PaymentHistoryItem>) {
        paymentDao.insertAll(items.map { it.toEntity() })
    }

    override suspend fun getCachedPaymentHistory(userId: String): List<PaymentHistoryItem> {
        return paymentDao.getHistoryByUserId(userId).map { it.toDomain() }
    }
}
