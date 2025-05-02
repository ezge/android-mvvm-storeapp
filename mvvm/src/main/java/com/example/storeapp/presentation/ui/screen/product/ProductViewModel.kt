package com.example.storeapp.presentation.ui.screen.product

import androidx.lifecycle.ViewModel
import com.example.storeapp.domain.model.Product
import com.example.storeapp.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase) : ViewModel() {

        private val _products = MutableStateFlow<List<Product>>(emptyList())
        val products: StateFlow<List<Product>> = _products

        private val _cart = MutableStateFlow<List<Product>>(emptyList())
        val cart: StateFlow<List<Product>> = _cart

        init {
            fetchProducts()
        }

        private fun fetchProducts() {
            viewModelScope.launch {
                _products.value = getProductsUseCase()
            }
        }

        fun addToCart(product: Product) {
            _cart.value += product
        }

        fun removeFromCart(product: Product) {
            _cart.value -= product
        }

        fun clearCart() {
            _cart.value = emptyList()
        }

        fun getTotalPrice(): Double {
            return _cart.value.sumOf { it.price }
        }
}

