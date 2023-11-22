package com.example.reviewlog.data.remote

import com.example.reviewlog.model.Address
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SignUpDto(
    @Json(name = "id")
    val id:String,
    @Json(name = "password")
    val password:String,
    @Json(name = "nickName")
    val nickName:String,
    @Json(name = "address")
    val address: Address
)
