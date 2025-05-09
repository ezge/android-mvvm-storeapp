package com.example.storeapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.storeapp.data.model.response.PaymentHistoryItem

@Entity(tableName = "payments")
data class PaymentEntity(
    @PrimaryKey val transactionId: String,
    val userId: String,
    val amount: Double,
    val date: String,
    val status: String
)

fun PaymentEntity.toDomain(): PaymentHistoryItem {
    return PaymentHistoryItem(
        transactionId = id,
        amount = amount,
        date = date,
        status = status
    )
}


