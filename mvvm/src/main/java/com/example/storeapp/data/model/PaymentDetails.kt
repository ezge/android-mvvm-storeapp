package com.example.storeapp.data.model

import com.example.storeapp.domain.model.PaymentMethod

data class PaymentDetails(
    val method: PaymentMethod,
    val amount: Double,
    val cardDetails: CardDetails? = null // if method is CREDIT_CARD
)
