package com.example.transfers.data.repository

import com.example.transfers.domain.model.Contact
import com.example.transfers.utils.Result

interface ContactDataSource {
    interface Remote {
        suspend fun getContacts(): Result<List<Contact>>
    }

    interface Local {
        suspend fun getContacts(): Result<List<Contact>>
    }
}
