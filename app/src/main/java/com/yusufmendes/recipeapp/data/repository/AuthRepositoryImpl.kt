package com.yusufmendes.recipeapp.data.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.repos.AuthRepository
import com.yusufmendes.recipeapp.util.AppResult
import com.yusufmendes.recipeapp.util.attempt
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val database: FirebaseFirestore
) : AuthRepository {
    override suspend fun login(email: String, password: String): AppResult<AuthResult> = attempt {
        firebaseAuth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun forgotPassword(email: String): AppResult<Unit> = attempt {
        firebaseAuth.sendPasswordResetEmail(email).await()
    }

    override suspend fun register(email: String, password: String): AppResult<AuthResult> =
        attempt {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        }

    override suspend fun saveRegisterData(user: Users): AppResult<Void> = attempt {
        database.collection("Users").document("${user.uid}").set(user).await()
    }
}