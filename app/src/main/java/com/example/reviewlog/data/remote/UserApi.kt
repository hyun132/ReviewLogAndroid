package com.example.reviewlog.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {

    @POST("/join")
    suspend fun signUp(@Body userInfo:SignUpDto):Response<ResponseDto<String>>
//    suspend fun signUp(id:String, password:String, nickName:String, address:Address):Response<String>

    @POST("/logIn")
    suspend fun login(id:String, password: String):Response<UserDto> // 추후에 tocken으로 변경할 것.

}