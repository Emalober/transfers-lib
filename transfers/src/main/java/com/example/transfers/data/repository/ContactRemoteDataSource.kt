package com.example.transfers.data.repository

import com.example.transfers.data.entity.toDomain
import com.example.transfers.data.remote.ContactsService
import com.example.transfers.domain.model.Contact
import com.example.transfers.utils.Result

class ContactRemoteDataSource(
    private val service: ContactsService
): ContactDataSource.Remote {
    override suspend fun getContacts(): Result<List<Contact>> = try {
        val result = service.getContacts()
        Result.Success(result.map { it.toDomain() })
    } catch (e: Exception) {
        Result.Error(e)
    }
}
