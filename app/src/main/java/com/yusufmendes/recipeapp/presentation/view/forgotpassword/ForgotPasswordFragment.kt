package com.yusufmendes.recipeapp.presentation.view.forgotpassword

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentForgotPasswordBinding
import com.yusufmendes.recipeapp.util.failShowSnackbar
import com.yusufmendes.recipeapp.util.successShowSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment(R.layout.fragment_forgot_password) {

    private lateinit var binding: FragmentForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()
    private lateinit var email: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentForgotPasswordBinding.bind(view)

        binding.forgotPasswordTl.passwordTlTitleTv.setText(R.string.forgot_password)

        binding.forgotPasswordTl.passwordTlBackIv.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.forgotPasswordButton.setOnClickListener {
            forgotPasswordButton()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.forgotPasswordLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                view?.successShowSnackbar("$email adresine şifre güncelleme bağlantısı gönderilmiştir. Email adresinizi kontrol ediniz.")
                findNavController().popBackStack()
            }?.doOnFailure {
                view?.failShowSnackbar("Güncelleme başarısız! Email'i kontrol ediniz.")
            }
        }
    }

    private fun forgotPasswordButton() {
        email = binding.loginEmailEt.text.toString().trim()

        if (isEligibleToForgotPassword(binding, email)) {
            viewModel.getForgotPassword(email)
        }
    }

    private fun isEligibleToForgotPassword(
        binding: FragmentForgotPasswordBinding,
        email: String
    ): Boolean {
        if (email.isEmpty()) {
            binding.loginEmailEt.error = "Email boş olamaz!"
            binding.loginEmailEt.requestFocus()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.loginEmailEt.error = "Email'i kontrol ediniz!"
            binding.loginEmailEt.requestFocus()
            return false
        }
        return true
    }
}