package com.example.storeapp.presentation.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.storeapp.domain.model.CartItem
import com.example.storeapp.domain.model.Order
import com.example.storeapp.domain.usecase.CalculateTotalPriceUseCase
import com.example.storeapp.domain.usecase.PlaceOrderUseCase
import com.example.storeapp.presentation.navigation.AppNavHost
import com.example.storeapp.presentation.ui.viewmodel.CartViewModel
import com.example.storeapp.presentation.ui.viewmodel.ProductViewModel
import com.example.storeapp.presentation.ui.theme.StoreAppTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //private val viewModel: ProductViewModel by viewModels()
    //private val cartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreAppTheme {
                AppNavHost()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview(viewModel: ProductViewModel = viewModel(),
                    cartViewModel: CartViewModel = viewModel()) {
    StoreAppTheme {
        AppNavHost()
    }
}

