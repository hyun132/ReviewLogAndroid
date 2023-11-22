package com.example.reviewlog.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Address {
    @Json(name = "city")
    private var city: String? = null
    @Json(name = "street")
    private var street: String? = null
    @Json(name = "zipcode")
    private var zipcode: String? = null
}
