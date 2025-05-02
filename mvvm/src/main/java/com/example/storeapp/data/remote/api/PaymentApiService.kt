package com.example.storeapp.data.remote.api

import com.example.storeapp.data.model.request.PaymentRequest
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.data.model.response.PaymentResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PaymentApiService {
    @POST("payments/process")
    suspend fun processPayment(@Body request: PaymentRequest): PaymentResponse

    @GET("payments/history")
    suspend fun getPaymentHistory(@Query("userId") userId: String): List<PaymentHistoryItem>
}
