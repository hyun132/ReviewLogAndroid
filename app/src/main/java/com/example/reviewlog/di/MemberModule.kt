package com.example.reviewlog.di

import com.example.reviewlog.data.repository.UserRepository
import com.example.reviewlog.data.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MemberModule {

    @Binds
    @Singleton
    abstract fun bindMemberRepository(userRepositoryImpl: UserRepositoryImpl):UserRepository

//    @Binds
//    @Singleton
//    abstract fun bindReviewRepository(rem):UserRepository
}