package com.yusufmendes.recipeapp.presentation.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentHomeBinding
import com.yusufmendes.recipeapp.presentation.adapter.CategoryAdapter
import com.yusufmendes.recipeapp.util.failShowSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.categoryRv.setHasFixedSize(true)
        categoryAdapter = CategoryAdapter()
        binding.categoryRv.adapter = categoryAdapter

        viewModel.getCategoryList()
        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                categoryAdapter.updateCategoryList(it)
            }?.doOnFailure {
                view?.failShowSnackbar("Categori listesi boş!")
            }
        }
    }
}