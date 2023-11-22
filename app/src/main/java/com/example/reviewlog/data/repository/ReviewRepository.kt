package com.example.reviewlog.data.repository

import com.example.reviewlog.model.Review
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    fun getReviews(): Flow<List<Review>>
}