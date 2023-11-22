package com.example.reviewlog.data.remote

data class ResponseDto<T>(
    val status:Int,
    val message:String,
    val data:T
)