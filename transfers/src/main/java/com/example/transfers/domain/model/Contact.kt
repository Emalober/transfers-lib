package com.example.transfers.domain.model

import java.util.Locale

data class Contact(
    val firstName: String,
    val lastName: String,
    val isClient: Boolean = false,
    val imageUrl: String? = null
) {
    fun contains(searchedText: String): Boolean {
        return "$firstName $lastName".lowercase(Locale.getDefault())
            .contains(searchedText.lowercase(Locale.getDefault()))
    }
}
