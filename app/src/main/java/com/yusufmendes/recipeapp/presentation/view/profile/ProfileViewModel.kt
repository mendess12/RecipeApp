package com.yusufmendes.recipeapp.presentation.view.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.recipeapp.data.model.Users
import com.yusufmendes.recipeapp.domain.usecases.profile.GetUserDataUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getUserDataUseCases: GetUserDataUseCases
) : ViewModel() {

    var userDataLiveData = MutableLiveData<AppResult<Users>>()

    fun getUserData(uid: String) = viewModelScope.launch {
        val result = getUserDataUseCases.getUserData(uid)
        userDataLiveData.postValue(result)
    }
}