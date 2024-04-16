package com.example.transfers.presentation.contacts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.transfers.domain.model.Contact
import com.example.transfers.presentation.components.ContactCard


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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsListScreen(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
    onSelectContact: (Contact) -> Unit,
    viewModel: ContactsViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val contacts = viewModel.contacts.observeAsState(emptyList())
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Mis contactos")
            }
        )
        //SearchView(textState)
        Spacer(modifier = Modifier.height(36.dp))
        ContactsListContent(
            modifier = modifier,
            filterState = textState,
            contacts = contacts.value,
            onSelectContact = onSelectContact
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactsListContent(
    modifier: Modifier = Modifier,
    filterState: MutableState<TextFieldValue>,
    contacts: List<Contact> = emptyList(),
    onSelectContact: (Contact) -> Unit,
) {
    var filteredContacts: List<Contact>

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val searchedText = filterState.value.text
        filteredContacts = if (searchedText.isEmpty()) {
            contacts
        } else {
            contacts.filter { it.contains(searchedText) }
        }
        
        val grouped = filteredContacts.groupBy { it.isClient }

        grouped.forEach { (initial, contactsForInitial) ->

            stickyHeader {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Text(
                        text = if (initial) "Contactos con Gcb" else "Invitar a usar Gcb",
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
            items(contactsForInitial.size) { index ->
                val contact = contactsForInitial[index]
                ContactCard(
                    modifier = Modifier.clickable(onClick = {
                        onSelectContact(contact)
                    }),
                    contact = contact
                )
            }
        }
    }
}

@Preview("default", widthDp = 360, heightDp = 640)
@Composable
fun ContactsListContentPreview() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    MaterialTheme {
        ContactsListContent(
            modifier = Modifier,
            textState,
            contacts = contactList,
            onSelectContact = {}
        )
    }
}
