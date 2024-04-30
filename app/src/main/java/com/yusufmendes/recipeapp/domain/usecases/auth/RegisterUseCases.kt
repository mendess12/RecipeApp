package com.yusufmendes.recipeapp.domain.usecases.auth

import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class RegisterUseCases @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun register(email: String, password: String): AppResult<AuthResult> =
        authRepository.register(email, password)
}