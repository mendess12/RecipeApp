package com.yusufmendes.recipeapp.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.domain.repos.HomeRepository
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val database: FirebaseFirestore
) : HomeRepository {
    override suspend fun getCategoryList(): List<Category> =
        database.collection("category").get().await().toObjects(Category::class.java)
}