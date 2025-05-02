package com.example.storeapp.data.remote.api

import com.example.storeapp.data.model.PaymentDetails
import com.example.storeapp.data.model.ProductDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("products")
    suspend fun getProducts(): List<ProductDto>

    @POST("orders")
    suspend fun placeOrder(@Body order: Map<String, Any>): Boolean

    @POST("orders/payment")
    suspend fun processPayment(@Body paymentDetails: PaymentDetails): Boolean
}