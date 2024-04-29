package com.yusufmendes.recipeapp.presentation.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)

        binding.profileTl.tlTitleTv.setText(R.string.profile)

        binding.profileChangePasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_changePasswordFragment2)
        }

        binding.profileLogoutIv.setOnClickListener {
            findNavController().navigate(R.id.auth_nav_graph)
        }
    }

}