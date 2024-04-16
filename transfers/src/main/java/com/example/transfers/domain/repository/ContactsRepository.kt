package com.example.transfers.domain.repository

import com.example.transfers.domain.model.Contact

interface ContactsRepository {
    fun getContacts(): Result<List<Contact>>

}
