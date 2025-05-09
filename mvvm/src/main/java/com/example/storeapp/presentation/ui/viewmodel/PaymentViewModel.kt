package com.example.storeapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.storeapp.data.model.response.PaymentHistoryItem
import com.example.storeapp.domain.repository.PaymentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentViewModel @Inject constructor(private val repository: PaymentRepository) : ViewModel() {

    private val _paymentHistory = MutableStateFlow<List<PaymentHistoryItem>>(emptyList())
    val paymentHistory: StateFlow<List<PaymentHistoryItem>> = _paymentHistory

    fun loadPaymentHistory(userId: String) {
        viewModelScope.launch {
            val history = repository.getPaymentHistory(userId)
            _paymentHistory.let { history }
        }
    }
}