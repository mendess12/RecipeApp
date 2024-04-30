package com.yusufmendes.recipeapp.domain.usecases.auth

import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class ForgotPasswordUseCases @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend fun forgotPassword(email: String): AppResult<Unit> =
        authRepository.forgotPassword(email)
}