package com.yusufmendes.recipeapp.domain.repos

import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.util.AppResult

interface ProfileRepository {

    suspend fun getUserData(uid: String): AppResult<Users>
    suspend fun changePassword(password: String, newPassword: String): AppResult<Unit>
}