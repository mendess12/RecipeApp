package com.yusufmendes.recipeapp.domain.repos

import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.util.AppResult

interface AuthRepository {

    suspend fun login(email: String, password: String): AppResult<AuthResult>
    suspend fun forgotPassword(email: String): AppResult<Unit>
    suspend fun register(email: String, password: String): AppResult<AuthResult>
    suspend fun saveRegisterData(user: Users): AppResult<Void>
}