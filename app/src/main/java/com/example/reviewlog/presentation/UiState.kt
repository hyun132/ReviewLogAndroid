package com.example.reviewlog.presentation

data class UiState(
    val result:String?=null,
    var isLoading:Boolean=false,
    var error:String?=null
)