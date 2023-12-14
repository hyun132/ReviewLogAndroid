package com.example.reviewlog.presentation

data class UiState(
    var result:String?=null,
    var isLoading:Boolean=false,
    var error:String?=null,
    var navigate:String? = null
)