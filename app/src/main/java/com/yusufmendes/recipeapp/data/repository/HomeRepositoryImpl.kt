package com.yusufmendes.recipeapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.domain.repos.HomeRepository
import com.yusufmendes.recipeapp.util.AppResult
import com.yusufmendes.recipeapp.util.attempt
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val database: FirebaseFirestore
) : HomeRepository {
    override suspend fun getCategoryList(): AppResult<List<Category>> = attempt {
        database.collection("category").get().await().toObjects(Category::class.java)
    }

}