package com.example.transfers.presentation.contacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.transfers.domain.model.Contact
import com.example.transfers.domain.usecase.GetContactsUseCase
import com.example.transfers.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val getContacts: GetContactsUseCase
): ViewModel() {

    data class ContactsUiState(
        val isLoading: Boolean = true,
        val noDataAvailable: Boolean = false
    )

    private val _uiState: MutableStateFlow<ContactsUiState> = MutableStateFlow(ContactsUiState())
    val uiState = _uiState.asStateFlow()

    private val _contacts: MutableLiveData<List<Contact>> = MutableLiveData<List<Contact>>(emptyList())
    val contacts: LiveData<List<Contact>> = _contacts

    init {
        viewModelScope.launch {
            _uiState.value = ContactsUiState()
            delay(1000L)
            when (val result = getContacts()) {
                is Result.Error -> _uiState.value = ContactsUiState(isLoading = false, noDataAvailable = true)
                is Result.Success -> {
                    _uiState.value = ContactsUiState(isLoading = false)
                    _contacts.value = result.data
                }

                else -> {}
            }

        }
    }
}
