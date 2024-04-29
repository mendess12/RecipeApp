package com.yusufmendes.recipeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusufmendes.recipeapp.data.model.Category
import com.yusufmendes.recipeapp.databinding.CategoryItemBinding
import com.yusufmendes.recipeapp.util.downloadImage

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val categoryList = arrayListOf<Category>()

    inner class CategoryViewHolder(private val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category) {
            with(binding) {
                categoryTitleTv.text = category.name
                category.imageUrl?.let { categoryIv.downloadImage(it) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            CategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categoryList[position]
        holder.bind(category)
    }

    fun updateCategoryList(updateCategoryList: List<Category>) {
        categoryList.clear()
        categoryList.addAll(updateCategoryList)
        notifyDataSetChanged()
    }
}