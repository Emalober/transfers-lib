package com.example.transfers.domain.repository

import com.example.transfers.domain.model.Contact
import com.example.transfers.utils.Result

interface ContactsRepository {
    suspend fun getContacts(): Result<List<Contact>>

}
