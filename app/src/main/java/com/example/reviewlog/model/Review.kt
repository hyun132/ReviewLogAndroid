package com.example.reviewlog.model

import com.squareup.moshi.JsonClass
import java.time.LocalDateTime

@JsonClass(generateAdapter = true)
class Review (
    private var id: Long?,
    private var title: String?,
    private var contents: String?,
    private var createdTime: LocalDateTime?,
    private var useTime: LocalDateTime?,
    private var address: Address?,
    private var photo: String?
)


