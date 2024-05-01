package com.yusufmendes.recipeapp.presentation.view.login

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentLoginBinding
import com.yusufmendes.recipeapp.util.failShowSnackbar
import com.yusufmendes.recipeapp.util.successShowSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.loginForgotPasswordTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        binding.loginRegisterTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.loginButton.setOnClickListener {
            loginButton()
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                view?.successShowSnackbar("Giriş başarılı.")
                findNavController().navigate(R.id.action_loginFragment_to_nav_graph)
            }?.doOnFailure {
                view?.failShowSnackbar("Giriş başarısız! Email ve şifrenizi kontrol ediniz.")
            }
        }
    }

    private fun loginButton() {
        val email = binding.loginEmailEt.text.toString().trim()
        val password = binding.loginPasswordEt.text.toString().trim()

        if (isEligibleToLogin(binding, email, password)) {
            viewModel.getLogin(email, password)
        }
    }

    private fun isEligibleToLogin(
        binding: FragmentLoginBinding,
        email: String,
        password: String
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
        if (password.isEmpty() || password.length < 6) {
            binding.loginPasswordEt.error =
                "Şifrenizi kontrol edin,şifre en az 6 karakter olmalıdır!"
            binding.loginPasswordEt.requestFocus()
            return false
        }
        return true
    }
}