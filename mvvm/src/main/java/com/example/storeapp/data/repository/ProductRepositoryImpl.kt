package com.example.storeapp.data.repository

import com.example.storeapp.data.remote.api.ApiService
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.repository.ProductRepository

class ProductRepositoryImpl(private val api: ApiService): ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.getProducts().map { Product(it.id, it.name, it.price) }
    }
}