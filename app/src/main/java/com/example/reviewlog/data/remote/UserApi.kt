package com.example.reviewlog.data.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("/api/v1/auth/join")
    suspend fun signUp(@Body userInfo:SignUpDto):Response<ResponseDto<String>>
//    suspend fun signUp(id:String, password:String, nickName:String, address:Address):Response<String>

    @POST("/api/v1/login")
    suspend fun login(@Body userInfo:LoginDto):Response<ResponseDto<TokenInfoDto>> // 추후에 tocken으로 변경할 것.

    @POST("/api/v1/login")
    suspend fun autoLogin():Response<ResponseDto<TokenInfoDto>> // 추후에 tocken으로 변경할 것.


    @GET("/api/v1/user/myInfo")
    suspend fun userInfo():Response<UserDto>

}