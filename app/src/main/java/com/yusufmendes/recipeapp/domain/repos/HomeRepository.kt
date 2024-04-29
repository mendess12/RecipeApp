package com.yusufmendes.recipeapp.domain.repos

import com.yusufmendes.recipeapp.data.model.Category

interface HomeRepository {

    suspend fun getCategoryList() : List<Category>
}