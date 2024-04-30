package com.yusufmendes.recipeapp.presentation.view.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.AuthResult
import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.usecases.auth.RegisterUseCases
import com.yusufmendes.recipeapp.domain.usecases.auth.SaveRegisterDataUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCases: RegisterUseCases,
    private val saveRegisterDataUseCases: SaveRegisterDataUseCases
) : ViewModel() {

    var registerLiveData = MutableLiveData<AppResult<AuthResult>>()
    var saveRegisterLiveData = MutableLiveData<AppResult<Void>>()

    fun getRegister(email: String, password: String) = viewModelScope.launch {
        val result = registerUseCases.register(email, password)
        registerLiveData.postValue(result)
    }

    fun saveRegisterData(user: Users) = viewModelScope.launch {
        val result = saveRegisterDataUseCases.saveRegisterData(user)
        saveRegisterLiveData.postValue(result)
    }
}