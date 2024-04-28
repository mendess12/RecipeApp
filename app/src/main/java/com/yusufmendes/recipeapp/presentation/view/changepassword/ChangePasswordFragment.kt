package com.yusufmendes.recipeapp.presentation.view.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentChangePasswordBinding

class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {

    private lateinit var binding: FragmentChangePasswordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChangePasswordBinding.bind(view)

        binding.changePasswordTl.passwordTlTitleTv.setText(R.string.change_password)

        binding.changePasswordButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.changePasswordTl.passwordTlBackIv.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}