package com.example.storeapp.domain.usecase

import com.example.storeapp.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repository: ProductRepository) {
    suspend operator fun invoke() = repository.getProducts()
}