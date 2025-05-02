package com.example.storeapp.domain.usecase

import com.example.storeapp.data.model.CardDetails
import com.example.storeapp.domain.model.PaymentMethod
import javax.inject.Inject

class ProcessPaymentUseCase @Inject constructor(
    private val paymentRepository: PaymentRepository) {
    suspend operator fun invoke(paymentMethod: PaymentMethod,
                                amount: Double, cardDetails: CardDetails? = null): Boolean {
        return paymentRepository.processPayment(paymentMethod, amount, cardDetails)
    }
}