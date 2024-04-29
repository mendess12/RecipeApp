package com.yusufmendes.recipeapp.presentation.view.addrecipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentAddRecipeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddRecipeFragment : Fragment(R.layout.fragment_add_recipe) {

    private lateinit var binding: FragmentAddRecipeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAddRecipeBinding.bind(view)

        binding.addRecipeTl.tlTitleTv.setText(R.string.add_recipe)
    }
}