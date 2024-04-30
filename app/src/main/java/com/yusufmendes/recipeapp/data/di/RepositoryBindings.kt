package com.yusufmendes.recipeapp.data.di

import com.yusufmendes.recipeapp.data.repository.AuthRepositoryImpl
import com.yusufmendes.recipeapp.data.repository.HomeRepositoryImpl
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.domain.repos.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindings {

    @Singleton
    @Binds
    abstract fun bindHomeRepository(homeRepositoryImpl: HomeRepositoryImpl): HomeRepository

    @Singleton
    @Binds
    abstract fun bindAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository

}