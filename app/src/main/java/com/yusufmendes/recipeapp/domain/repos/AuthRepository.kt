package com.yusufmendes.recipeapp.domain.repos

import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.util.AppResult

interface AuthRepository {

    suspend fun login(email: String, password: String): AppResult<AuthResult>
}