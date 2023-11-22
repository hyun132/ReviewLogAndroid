package com.example.reviewlog.data.repository

import com.example.reviewlog.data.remote.UserDto
import com.example.reviewlog.domain.model.Resource
import com.example.reviewlog.model.Address

interface UserRepository {

    suspend fun signUp(
        id: String,
        password: String,
        nickName: String,
        address: Address
    ): Resource<String>

    suspend fun logIn(id: String, password: String): Resource<UserDto>
}