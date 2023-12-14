package com.example.reviewlog.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reviewlog.data.repository.UserRepository
import com.example.reviewlog.domain.model.Resource
import com.example.reviewlog.model.Address
import com.example.reviewlog.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val repository: UserRepository):ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    fun signUp(id: String, password: String, nickName: String, address: Address){
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            state = when(val response = repository.signUp(id,password,nickName, address)) {
                is Resource.Success ->{
                    state.copy(isLoading = false, result = response.data)
                }

                is Resource.Error -> {
                    state.copy(error = response.message,isLoading = false)
                }
            }
        }
    }

}