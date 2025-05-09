package com.example.storeapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.usecase.GetCartItemsUseCase
import com.example.storeapp.domain.usecase.RemoveFromCartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemsUseCase: GetCartItemsUseCase,
    private val removeFromCartUseCase: RemoveFromCartUseCase
) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    init {
        loadCartItems()
    }

    private fun loadCartItems() {
        _cartItems.value = getCartItemsUseCase()
    }

    fun removeItem(productId: Int) {
        removeFromCartUseCase(productId)
        loadCartItems() // Refresh
    }
}