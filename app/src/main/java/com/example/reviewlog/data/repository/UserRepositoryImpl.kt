package com.example.reviewlog.data.repository

import com.example.reviewlog.data.remote.LoginDto
import com.example.reviewlog.data.remote.SignUpDto
import com.example.reviewlog.data.remote.TokenInfoDto
import com.example.reviewlog.data.remote.UserApi
import com.example.reviewlog.data.remote.UserDto
import com.example.reviewlog.domain.model.Resource
import com.example.reviewlog.model.Address
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val api: UserApi) : UserRepository {
    override suspend fun signUp(
        id: String,
        password: String,
        nickName: String,
        address: Address
    ): Resource<String> {
        val dto = SignUpDto(id = id,password=password,nickName=nickName,address= Address())
        val result = api.signUp(dto)
        return if (result.isSuccessful) {
            Resource.Success(result.body()?.data)
        } else Resource.Error<String>(message = result.message())
    }

    override suspend fun logIn(
        id: String,
        password: String
    ): Resource<TokenInfoDto> {
        val result =
            api.login(LoginDto(id,password))
        return if (result.isSuccessful) {
            Resource.Success(result.body()?.data)
        } else Resource.Error<TokenInfoDto>(message = result.message())
    }

    override suspend fun autoLogin(): Resource<TokenInfoDto> {
        val result = api.autoLogin()
        return if (result.isSuccessful) {
            Resource.Success(result.body()?.data)
        } else Resource.Error<TokenInfoDto>(message = result.message())
    }

    override suspend fun getUserInfo(): Resource<UserDto> {
        val result = api.userInfo()
        return if (result.isSuccessful) {
            Resource.Success(result.body())
        } else Resource.Error<UserDto>(message = result.message())
    }


}