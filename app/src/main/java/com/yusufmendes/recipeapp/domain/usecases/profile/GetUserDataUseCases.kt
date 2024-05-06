package com.yusufmendes.recipeapp.domain.usecases.profile

import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.repos.ProfileRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class GetUserDataUseCases @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun getUserData(uid: String): AppResult<Users> = profileRepository.getUserData(uid)
}