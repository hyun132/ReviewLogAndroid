package com.example.reviewlog.data.remote

import com.example.reviewlog.model.Review
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDataDto (
    val nickName:String,
    val reviews: ArrayList<Review>
)