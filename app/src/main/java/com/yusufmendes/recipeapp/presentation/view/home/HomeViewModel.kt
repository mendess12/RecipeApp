package com.yusufmendes.recipeapp.presentation.view.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.domain.usecases.home.GetCategoryListUseCases
import com.yusufmendes.recipeapp.util.AppResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryListUseCases: GetCategoryListUseCases
) : ViewModel() {

    var categoryLiveData = MutableLiveData<AppResult<List<Category>>>()

    fun getCategoryList() = viewModelScope.launch {
        val result = categoryListUseCases.getCategoryList()
        categoryLiveData.postValue(result)
    }
}