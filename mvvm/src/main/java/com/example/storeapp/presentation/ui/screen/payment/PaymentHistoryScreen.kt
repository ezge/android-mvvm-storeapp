@file:Suppress("INFERRED_TYPE_VARIABLE_INTO_EMPTY_INTERSECTION_WARNING")

package com.example.storeapp.presentation.ui.screen.payment

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.storeapp.presentation.payment.PaymentHistoryItemView
import com.example.storeapp.presentation.ui.viewmodel.PaymentViewModel

@Suppress("TYPE_INTERSECTION_AS_REIFIED_WARNING")
@Composable
fun PaymentHistoryScreen(userId: String,
                         onPaymentClick: (String) -> Unit,
                         paymentViewModel: PaymentViewModel = hiltViewModel()) {
        val history by paymentViewModel.paymentHistory.collectAsState()

        LaunchedEffect(userId) {
            paymentViewModel.loadPaymentHistory(userId)
        }

        LazyColumn {
            items(history) { item ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)
                    .clickable { onPaymentClick(item.transactionId) }) {
                PaymentHistoryItemView(item)
            }
        }
    }
}