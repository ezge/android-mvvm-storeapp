package com.example.storeapp.domain.repository

import com.example.storeapp.domain.model.Product

interface ProductRepository {
   /* fun getProducts(): List<Product> {
        return listOf(
            Product(1, "Football", 29.99),
            Product(2, "Running Shoes", 79.99),
            Product(3, "Basketball", 34.99)
        )
    }*/
    suspend fun getProducts(): List<Product>
}
