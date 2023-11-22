package com.example.reviewlog.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.reviewlog.presentation.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(UiState(""))
    val uiState : StateFlow<UiState> = _uiState.asStateFlow()
}