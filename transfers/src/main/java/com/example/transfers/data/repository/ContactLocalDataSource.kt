package com.example.transfers.data.repository

import com.example.transfers.data.entity.toDomain
import com.example.transfers.data.exception.DataNotAvailableException
import com.example.transfers.data.local.ContactDao
import com.example.transfers.domain.model.Contact
import com.example.transfers.utils.Result

class ContactLocalDataSource(
    private val contactDao: ContactDao,
): ContactDataSource.Local {

    override suspend fun getContacts(): Result<List<Contact>> {
        val contacts = contactDao.getContacts()
        return if (contacts.isNotEmpty()) {
            Result.Success(contacts.map { it.toDomain() })
        } else {
            Result.Error(DataNotAvailableException())
        }
    }

}
