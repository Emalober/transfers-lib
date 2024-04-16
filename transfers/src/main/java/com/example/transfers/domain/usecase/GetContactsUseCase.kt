package com.example.transfers.domain.usecase

import com.example.transfers.domain.model.Contact
import com.example.transfers.domain.repository.ContactsRepository
import com.example.transfers.utils.Result
import javax.inject.Inject

// Define el caso de uso para obtener la lista de contactos
class GetContactsUseCase @Inject constructor(private val contactsRepository: ContactsRepository) {

    // Método para ejecutar el caso de uso y obtener la lista de contactos
    suspend operator fun invoke(): Result<List<Contact>> {
        // Llama al método del repositorio para obtener la lista de contactos
        return contactsRepository.getContacts()
    }
}
