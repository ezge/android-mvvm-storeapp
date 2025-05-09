package com.example.storeapp.presentation.payment

package com.example.storeapp.presentation.payment

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.PaymentHistoryItem

@Composable
fun PaymentHistoryItemView(item: PaymentHistoryItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Transaction ID: ${item.transactionId}")
            Text("Amount: $${item.amount}")
            Text("Date: ${item.date}")
            Text("Status: ${item.status}")
        }
    }
}
