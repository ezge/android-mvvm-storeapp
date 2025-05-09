package com.example.storeapp.presentation.ui.screen.checkout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.presentation.ui.screen.CheckoutViewModel

@Composable
fun CheckoutScreen(cartItems: List<CartItem>,
                   checkoutViewModel: CheckoutViewModel = hiltViewModel(),
                   onBack: () -> Unit) {
    // Hoisted state for total price
    var totalPrice by remember { mutableDoubleStateOf(0.0) }
    val orderPlaced by checkoutViewModel.orderPlaced.collectAsState()

    // Calculate the total price when the cart items change
    LaunchedEffect(cartItems) {
        totalPrice = checkoutViewModel.calculateTotal(cartItems)
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Checkout", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Total amount: $${"%.2f".format(totalPrice)}")
        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { checkoutViewModel.placeOrder(cartItems) }) {
                Text("Place Order")
            }
            Button(onClick = onBack) { Text("Back") }
        }

        orderPlaced?.let {
            Spacer(modifier = Modifier.height(16.dp))
            if (it) Text("Order placed successfully!", color = MaterialTheme.colorScheme.primary)
            else Text("Failed to place order.", color = MaterialTheme.colorScheme.error)
        }
    }
}