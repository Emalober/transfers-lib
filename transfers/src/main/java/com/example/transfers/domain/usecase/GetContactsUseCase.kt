package com.example.transfers.domain.usecase

import com.example.transfers.domain.model.Contact
import com.example.transfers.domain.repository.ContactsRepository

private val contactList = listOf(
    Contact(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = true),
    Contact(firstName = "Agustina", lastName = "Fernandez Torna", isClient = true),
    Contact(firstName = "Manuel ", lastName = "Martinez", isClient = true),
    Contact(firstName = "Julieta Daniela", lastName = "Perez", isClient = true),
    Contact(firstName = "Diana María", lastName = "Koi", isClient = true),
    Contact(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = false),
    Contact(firstName = "Agustina", lastName = "Fernandez Torna", isClient = false),
    Contact(firstName = "Manuel", lastName = "Martinez", isClient = false),
    Contact(firstName = "Julieta Daniela", lastName = "Perez", isClient = false),
    Contact(firstName = "Diana María", lastName = "Koi", isClient = false),
    Contact(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = false),
    Contact(firstName = "Agustina", lastName = "Fernandez Torna", isClient = false),
    Contact(firstName = "Manuel", lastName = "Martinez", isClient = false),
    Contact(firstName = "Julieta Daniela", lastName = "Perez", isClient = false),
    Contact(firstName = "Diana María", lastName = "Koi", isClient = false)
)

// Define el caso de uso para obtener la lista de contactos
class GetContactsUseCase(private val contactsRepository: ContactsRepository) {

    // Método para ejecutar el caso de uso y obtener la lista de contactos
    suspend fun execute(): Result<List<Contact>> {
        // Llama al método del repositorio para obtener la lista de contactos
        return contactsRepository.getContacts()
    }
}
