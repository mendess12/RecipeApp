package com.yusufmendes.recipeapp.domain.usecases.auth

import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class SaveRegisterDataUseCases @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun saveRegisterData(user: Users): AppResult<Void> =
        authRepository.saveRegisterData(user)
}