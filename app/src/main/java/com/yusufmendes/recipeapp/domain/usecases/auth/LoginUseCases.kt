package com.yusufmendes.recipeapp.domain.usecases.auth

import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class LoginUseCases @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun login(email: String, password: String): AppResult<AuthResult> =
        authRepository.login(email, password)
}