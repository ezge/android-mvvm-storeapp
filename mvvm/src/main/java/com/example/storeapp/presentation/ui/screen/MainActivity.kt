package com.example.storeapp.presentation.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.storeapp.presentation.navigation.AppNavHost
import com.example.storeapp.presentation.ui.screen.cart.CartViewModel
import com.example.storeapp.presentation.ui.screen.product.ProductViewModel
import com.example.storeapp.presentation.ui.theme.StoreAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val products by viewModel.products.collectAsState()
            val cart by cartViewModel.cartItems.collectAsState()

            AppNavHost(products = products,
                       onAddToCart = { viewModel.addToCart(it) },
                       onRemoveFromCart = { (cartViewModel::removeItem)(it.id) })
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview(viewModel: ProductViewModel = viewModel(),
                    cartViewModel: CartViewModel = viewModel()) {
    StoreAppTheme {
        val products by viewModel.products.collectAsState()

        AppNavHost(products = products,
                   onAddToCart = { viewModel.addToCart(it) },
                   onRemoveFromCart = { (cartViewModel::removeItem)(it.id) })
    }
}