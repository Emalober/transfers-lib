package com.example.transfers.data.remote

import com.example.transfers.data.entity.ContactDto
import retrofit2.http.GET

interface ContactsService {
    @GET("/contacts")
    suspend fun getContacts(): List<ContactDto>
}
