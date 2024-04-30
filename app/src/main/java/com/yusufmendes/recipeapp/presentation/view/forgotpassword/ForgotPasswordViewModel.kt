package com.yusufmendes.recipeapp.presentation.view.forgotpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.recipeapp.domain.usecases.auth.ForgotPasswordUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val forgotPasswordUseCases: ForgotPasswordUseCases
) : ViewModel() {

    var forgotPasswordLiveData = MutableLiveData<AppResult<Unit>>()

    fun getForgotPassword(email: String) = viewModelScope.launch {
        val result = forgotPasswordUseCases.forgotPassword(email)
        forgotPasswordLiveData.postValue(result)
    }
}