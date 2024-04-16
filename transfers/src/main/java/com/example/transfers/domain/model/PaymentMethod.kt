package com.example.transfers.domain.model

import androidx.annotation.DrawableRes
import com.example.transfers.R

enum class PaymentMethodType(
    val description: String,
    @DrawableRes val icon: Int
) {
    VISA("Visa", R.drawable.ic_visa),
    MASTER("Mastercard", R.drawable.ic_mastercard),
    AMEX("Amex", R.drawable.ic_amex),
    WALLET("Billetera", R.drawable.ic_add_card),
}

data class PaymentMethod(
    val uuid: String,
    val name: String,
    val description: String,
    val last4Digit: String? = null,
    val balance: Double = 0.0,
    val currency: String = "$",
    val isFavorite: Boolean = false,
    val type: PaymentMethodType,
    val tags: List<String> = emptyList(),
    val selected: Boolean = false,
    val enabled: Boolean = true
)
