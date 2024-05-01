package com.yusufmendes.recipeapp.data.repository

import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.repos.ProfileRepository
import com.yusufmendes.recipeapp.util.AppResult
import com.yusufmendes.recipeapp.util.attempt
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val database: FirebaseFirestore,
    private val firebaseAuth: FirebaseAuth
) : ProfileRepository {
    override suspend fun getUserData(uid: String): AppResult<Users> = attempt {
        database.collection("Users").document(uid).get().await().toObject(Users::class.java)!!
    }

    override suspend fun changePassword(password: String, newPassword: String): AppResult<Unit> {
        return attempt {
            val user = firebaseAuth.currentUser
            val email = user?.email
            if (user != null && email != null) {
                val credential = EmailAuthProvider.getCredential(email, password)
                user.reauthenticate(credential).await()
                user.updatePassword(newPassword).await()
            }
        }
    }
}