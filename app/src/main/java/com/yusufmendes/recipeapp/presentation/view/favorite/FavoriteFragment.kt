package com.yusufmendes.recipeapp.presentation.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)

        binding.favoriteTl.tlTitleTv.setText(R.string.favorite)
    }

}