package com.example.storeapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.CartItem

@Composable
fun CartItemCard(item: CartItem, onRemoveFromCart: () -> Unit) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth()
                               .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = item.product.name)
                Text(text = "Qty: ${item.quantity}")
                Text(text = "$${item.product.price}")
            }
            IconButton(onClick = onRemoveFromCart) {
                Icon(Icons.Default.Delete, contentDescription = "Remove")
            }
        }
    }
}