package com.yusufmendes.recipeapp.presentation.view.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.domain.usecases.auth.RegisterUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCases: RegisterUseCases
) : ViewModel() {

    var registerLiveData = MutableLiveData<AppResult<AuthResult>>()

    fun getRegister(email: String, password: String) = viewModelScope.launch {
        val result = registerUseCases.register(email, password)
        registerLiveData.postValue(result)
    }
}