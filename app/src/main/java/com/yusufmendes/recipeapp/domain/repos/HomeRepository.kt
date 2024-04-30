package com.yusufmendes.recipeapp.domain.repos

import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.util.AppResult

interface HomeRepository {

    suspend fun getCategoryList() : AppResult<List<Category>>
}