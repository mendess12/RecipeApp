package com.yusufmendes.recipeapp.presentation.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.domain.usecases.auth.LoginUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {

    var loginLiveData = MutableLiveData<AppResult<AuthResult>>()

    fun getLogin(email: String, password: String) = viewModelScope.launch {
        val result = loginUseCases.login(email, password)
        loginLiveData.postValue(result)
    }
}