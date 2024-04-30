package com.yusufmendes.recipeapp.domain.usecases.home

import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.domain.repos.HomeRepository
import com.yusufmendes.recipeapp.util.AppResult
import javax.inject.Inject

class GetCategoryListUseCases @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun getCategoryList(): AppResult<List<Category>> = homeRepository.getCategoryList()
}