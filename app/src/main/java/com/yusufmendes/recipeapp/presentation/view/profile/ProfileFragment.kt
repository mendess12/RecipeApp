package com.yusufmendes.recipeapp.presentation.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.profileTl.tlTitleTv.setText(R.string.profile)
    }

}