package com.example.transfers.data.repository

import com.example.transfers.domain.model.Contact
import com.example.transfers.domain.repository.ContactsRepository
import com.example.transfers.utils.Result
import javax.inject.Inject

class ContactsRepositoryImpl @Inject constructor(
    private val remote: ContactDataSource.Remote,
    private val local: ContactDataSource.Local,
): ContactsRepository {
    override suspend fun getContacts(): Result<List<Contact>> {
        return local.getContacts()
    }

}
