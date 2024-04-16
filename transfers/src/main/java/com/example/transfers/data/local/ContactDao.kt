package com.example.transfers.data.local

import com.example.transfers.data.entity.ContactDto

class ContactDao {

    private val contactList = listOf(
        ContactDto(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = true),
        ContactDto(firstName = "Agustina", lastName = "Fernandez Torna", isClient = true),
        ContactDto(firstName = "Manuel ", lastName = "Martinez", isClient = true),
        ContactDto(firstName = "Julieta Daniela", lastName = "Perez", isClient = true),
        ContactDto(firstName = "Diana María", lastName = "Koi", isClient = true),
        ContactDto(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = false),
        ContactDto(firstName = "Agustina", lastName = "Fernandez Torna", isClient = false),
        ContactDto(firstName = "Manuel", lastName = "Martinez", isClient = false),
        ContactDto(firstName = "Julieta Daniela", lastName = "Perez", isClient = false),
        ContactDto(firstName = "Diana María", lastName = "Koi", isClient = false),
        ContactDto(firstName = "Juan Agustín", lastName = "Gonzalez", isClient = false),
        ContactDto(firstName = "Agustina", lastName = "Fernandez Torna", isClient = false),
        ContactDto(firstName = "Manuel", lastName = "Martinez", isClient = false),
        ContactDto(firstName = "Julieta Daniela", lastName = "Perez", isClient = false),
        ContactDto(firstName = "Diana María", lastName = "Koi", isClient = false)
    )

    fun getContacts() = contactList

}
