package com.example.storeapp.presentation.navigation

import com.example.storeapp.presentation.ui.screen.checkout.CheckoutScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.storeapp.presentation.ui.screen.payment.PaymentDetailScreen
import com.example.storeapp.presentation.ui.screen.payment.PaymentHistoryScreen
import com.example.storeapp.presentation.ui.screen.cart.CartScreen
import com.example.storeapp.presentation.ui.viewmodel.CartViewModel
import com.example.storeapp.presentation.ui.screen.product.ProductListScreen
import com.example.storeapp.presentation.ui.viewmodel.ProductViewModel
import androidx.compose.runtime.getValue
import com.example.storeapp.presentation.ui.viewmodel.CheckoutViewModel

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    val productViewModel: ProductViewModel = hiltViewModel()
    val cartViewModel: CartViewModel = hiltViewModel()
    val checkoutViewModel: CheckoutViewModel = hiltViewModel()

    val products by productViewModel.products.collectAsState()
    val cart by cartViewModel.cartItems.collectAsState()

    NavHost(navController = navController, startDestination = Screen.ProductList.route) {
        composable(Screen.ProductList.route) {
            ProductListScreen(products = products,
                              onAddToCart = productViewModel::addToCart,
                              onNavigateToCart = { navController.navigate(Screen.Cart.route) }) }
        composable(Screen.Cart.route) {
            CartScreen(cart = cart,
                       onRemoveFromCart = {(cartViewModel::removeItem)(it.id.toInt())},
                       onClearCart = productViewModel::clearCart,
                       onBack = { navController.popBackStack() },
                       onProceedToCheckout = { navController.navigate(Screen.Checkout.route) }) }
        composable(Screen.Checkout.route) {
            CheckoutScreen(cartItems = cart,
                           checkoutViewModel = checkoutViewModel,
                           onBack = { navController.popBackStack() }) }
        composable(Screen.PaymentHistory.route) {
            PaymentHistoryScreen(userId = "user123",
                                 onPaymentClick = { txId ->
                                      navController.navigate(Screen.PaymentDetail.createRoute(txId))})
        }

        composable(Screen.PaymentDetail.route,
                   arguments = listOf(navArgument("transactionId") { type = NavType.StringType })) { backStackEntry ->
                        val transactionId = backStackEntry.arguments?.getString("transactionId") ?: ""
                                        PaymentDetailScreen(transactionId)
        }
    }
}
