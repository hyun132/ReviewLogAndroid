package com.example.reviewlog.data.remote

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDto(
    @field:Json(name="user")
    val userData:UserDataDto
)