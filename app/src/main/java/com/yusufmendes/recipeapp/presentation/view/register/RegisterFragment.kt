package com.yusufmendes.recipeapp.presentation.view.register

import android.os.Bundle
import android.util.Patterns
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.registerButton.setOnClickListener {
            registerButton()
        }

        binding.registerLoginTv.setOnClickListener {
            findNavController().popBackStack()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.registerLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                Snackbar.make(requireView(), "Kayıt başarılı", Snackbar.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }?.doOnFailure {
                Snackbar.make(
                    requireView(),
                    "Kayıt başarısız. Girdiğiniz değerleri kontrol ediniz!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun registerButton() {
        val email = binding.registerEmailEt.text.toString().trim()
        val password = binding.registerPasswordEt.text.toString().trim()
        val userName = binding.registerUserNameEt.text.toString().trim()

        if (isEligibleToRegister(binding, email, password, userName)) {
            viewModel.getRegister(email, password)
        }
    }

    private fun isEligibleToRegister(
        binding: FragmentRegisterBinding,
        email: String,
        password: String,
        userName: String
    ): Boolean {
        if (email.isEmpty()) {
            binding.registerEmailEt.error = "Email boş olamaz!"
            binding.registerEmailEt.requestFocus()
            return false
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.registerEmailEt.error = "Email'i kontrol ediniz!"
            binding.registerEmailEt.requestFocus()
            return false
        }
        if (userName.isEmpty()) {
            binding.registerUserNameEt.error = "Ad-Soyad boş olamaz!"
            binding.registerUserNameEt.requestFocus()
            return false
        }
        if (password.isEmpty() || password.length < 6) {
            binding.registerPasswordEt.error =
                "Şifrenizi kontrol edin,şifre en az 6 karakter olmalıdır!"
            binding.registerPasswordEt.requestFocus()
            return false
        }
        return true
    }
}