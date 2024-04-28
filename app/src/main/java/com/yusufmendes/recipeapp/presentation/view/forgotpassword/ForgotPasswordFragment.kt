package com.yusufmendes.recipeapp.presentation.view.forgotpassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgotPasswordBinding.bind(view)

        binding.forgotPasswordTl.passwordTlTitleTv.setText(R.string.forgot_password)
    }
}