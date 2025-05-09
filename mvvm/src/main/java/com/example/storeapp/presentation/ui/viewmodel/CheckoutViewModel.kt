package com.example.storeapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.usecase.CalculateTotalPriceUseCase
import com.example.storeapp.domain.usecase.PlaceOrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val calculateTotalPriceUseCase: CalculateTotalPriceUseCase,
    private val placeOrderUseCase: PlaceOrderUseCase
) : ViewModel() {

    private val _totalPrice = MutableStateFlow<Double>(0.0)
    val totalPrice: StateFlow<Double> = _totalPrice

    private val _orderPlaced = MutableStateFlow<Boolean?>(null)
    val orderPlaced: StateFlow<Boolean?> = _orderPlaced

    fun calculateTotal(cartItems: List<CartItem>): Double {
        _totalPrice.value = calculateTotalPriceUseCase(cartItems)
        return _totalPrice.value
    }

    fun placeOrder(cartItems: List<CartItem>) {
        val total = cartItems.sumOf { it.product.price * it.quantity }
        val order = Order(cartItems)

        viewModelScope.launch {
            val success = placeOrderUseCase(order)
            _orderPlaced.value = success
        }
    }
}