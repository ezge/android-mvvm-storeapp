package com.example.storeapp.presentation.navigation

import com.example.storeapp_mvvm.presentation.screen.checkout.CheckoutScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.storeapp.domain.model.Product
import com.example.storeapp.presentation.ui.screen.cart.CartScreen
import com.example.storeapp.presentation.ui.screen.cart.CartViewModel
import com.example.storeapp.presentation.ui.screen.checkout.CheckoutViewModel
import com.example.storeapp.presentation.ui.screen.product.ProductListScreen


@Composable
fun AppNavHost(products: List<Product>,
               onAddToCart: (Product) -> Unit,
               onRemoveFromCart: (Product) -> Unit) {
    val cartViewModel: CartViewModel = hiltViewModel()
    val checkoutViewModel: CheckoutViewModel = hiltViewModel()
    val cart = cartViewModel.cartItems.collectAsState().value

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "product_list") {
        composable("product_list") {
            ProductListScreen(products = products,
                              onAddToCart = onAddToCart,
                              onNavigateToCart = { navController.navigate("cart") }) }
        composable("cart") {
            CartScreen(cart = cart,
                       onRemoveFromCart = { productId -> cartViewModel.removeItem(productId) },
                       onBack = { navController.popBackStack() },
                       onProceedToCheckout = { navController.navigate("checkout") }) }
        composable("checkout") {
            CheckoutScreen(cartItems = cart,
                           checkoutViewModel = checkoutViewModel,
                           onBack = { navController.popBackStack() }) }
    }
}
