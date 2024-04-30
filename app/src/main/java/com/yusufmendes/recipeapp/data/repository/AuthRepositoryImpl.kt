package com.yusufmendes.recipeapp.data.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import com.yusufmendes.recipeapp.util.attempt
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {
    override suspend fun login(email: String, password: String): AppResult<AuthResult> = attempt {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun forgotPassword(email: String): AppResult<Unit> = attempt {
        firebaseAuth.sendPasswordResetEmail(email).await()
    }


}