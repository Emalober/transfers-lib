package com.example.transfers.data.entity

import com.google.gson.annotations.SerializedName

data class ContactDto(
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("isClient") val isClient: Boolean = false
)
