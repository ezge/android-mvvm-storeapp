package com.example.storeapp.presentation.payment

import com.example.storeapp.presentation.ui.screen.payment.PaymentHistoryScreen

@AndroidEntryPoint
class PaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MaterialTheme {
                    PaymentHistoryScreen(userId = "user123")
                }
            }
        }
    }
}
