package com.yusufmendes.recipeapp.presentation.view.changepassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.recipeapp.domain.usecases.profile.ChangePasswordUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChangePasswordViewModel @Inject constructor(
    private val changePasswordUseCases: ChangePasswordUseCases
) : ViewModel() {

    var changePasswordLiveData = MutableLiveData<AppResult<Unit>>()

    fun changePassword(password: String, newPassword: String) = viewModelScope.launch {
        val result = changePasswordUseCases.changePassword(password, newPassword)
        changePasswordLiveData.postValue(result)
    }
}