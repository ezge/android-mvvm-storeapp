package com.example.storeapp.presentation.ui.screen.cart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.presentation.component.CartItemCard



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(cart: List<CartItem>,
               onRemoveFromCart: () -> Unit,
               onClearCart: () -> Unit,
               onBack: () -> Unit,
               onProceedToCheckout: (List<CartItem>) -> Unit) {

    val cartItems by cartViewModel.cartItems

    var totalPrice by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(cart) {
        totalPrice = cart.sumOf { it.product.price * it.quantity }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (cart.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center) {
                    Text("Your cart is empty")
                }}
        else {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Cart", style = MaterialTheme.typography.titleLarge)

                LazyColumn { items(cart) { item ->
                    CartItemCard(item = item, onRemoveFromCart = { onRemoveFromCart(item.product.id) })
                } }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Total: $${"%.2f".format(totalPrice)}")

                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween) {

                    Button(modifier = Modifier.weight(1f).padding(start = 8.dp),
                           onClick = onClearCart,
                           enabled = cart.isNotEmpty()) {
                        Text("Remove All") }
                    Button(modifier = Modifier.weight(1f),
                        onClick = onBack,
                        enabled = cart.isNotEmpty()) {
                        Text("Continue Shopping") }
                    Button(modifier = Modifier.weight(1f).padding(end = 8.dp),
                           onClick = { onProceedToCheckout(cart) },
                           enabled = cart.isNotEmpty()) {
                        Text("Proceed to Checkout")
                    }
                }
            }
        }
    }
}
