package com.example.storeapp.data.mapper

class PaymentMapper {
    fun PaymentHistoryItem.toEntity(): PaymentEntity {
        return PaymentEntity(
            id = transactionId,
            amount = amount,
            date = date,
            status = status
        )
    }

    fun PaymentEntity.toDomain() = PaymentHistoryItem(transactionId, amount, date, status)

    fun PaymentHistoryItem.toEntity() = PaymentEntity(transactionId, "", amount, date, status)

}