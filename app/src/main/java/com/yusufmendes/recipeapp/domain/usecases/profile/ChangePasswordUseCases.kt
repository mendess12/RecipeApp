package com.yusufmendes.recipeapp.domain.usecases.profile

import com.yusufmendes.recipeapp.domain.repos.ProfileRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class ChangePasswordUseCases @Inject constructor(
    private val profileRepository: ProfileRepository
) {
    suspend fun changePassword(password: String, newPassword: String): AppResult<Unit> =
        profileRepository.changePassword(password, newPassword)
}