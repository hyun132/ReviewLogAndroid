package com.example.reviewlog.presentation.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reviewlog.data.remote.TokenInfoDto
import com.example.reviewlog.data.repository.DataStoreRepository
import com.example.reviewlog.data.repository.UserRepository
import com.example.reviewlog.domain.model.Resource
import com.example.reviewlog.presentation.UiState
import com.example.reviewlog.presentation.util.Screens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    var state by mutableStateOf(UiState())
    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    init {
//        getUserInfo()
        autoLogin()
    }

    fun login(id: String, pw: String) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            when (val result = userRepository.logIn(id, pw)) {
                is Resource.Success<TokenInfoDto> -> {
                    if (!result.data?.token.isNullOrEmpty()) {
                        dataStoreRepository.setUserPreference(DataStoreRepository.PreferenceKeys.TOKEN,result.data!!.token)
                        state = state.copy(isLoading = false, navigate = Screens.HomeScreen.route)
                    }
                }
                is Resource.Error -> {
                    state = state.copy(error = result.message, isLoading = false)
                }
            }
        }
    }

    fun autoLogin() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            when (val result = userRepository.autoLogin()) {
                is Resource.Success<TokenInfoDto> -> {
                    if (!result.data?.token.isNullOrEmpty()) {
                        dataStoreRepository.setUserPreference(DataStoreRepository.PreferenceKeys.TOKEN,result.data!!.token)
                        state = state.copy(isLoading = false, navigate = Screens.LoginScreen.route)
                    }
                }
                is Resource.Error -> {
                    state = state.copy(error = result.message, isLoading = false)
                }
            }
        }
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            dataStoreRepository.getUserPreference(DataStoreRepository.PreferenceKeys.TOKEN).collectLatest {token ->
                state = state.copy(isLoading = false)
                if(!token.isNullOrEmpty()){
                    userRepository.getUserInfo().data?.userData?.let {
                        state = state.copy(navigate = Screens.HomeScreen.route)
                    }
                }
            }
        }
    }
}