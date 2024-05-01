package com.yusufmendes.recipeapp.presentation.view.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentChangePasswordBinding
import com.yusufmendes.recipeapp.util.failShowSnackbar
import com.yusufmendes.recipeapp.util.successShowSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {

    private lateinit var binding: FragmentChangePasswordBinding
    private val viewModel: ChangePasswordViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentChangePasswordBinding.bind(view)

        binding.changePasswordTl.passwordTlTitleTv.setText(R.string.change_password)

        binding.changePasswordButton.setOnClickListener {
            changePasswordButton()
        }

        binding.changePasswordTl.passwordTlBackIv.setOnClickListener {
            findNavController().popBackStack()
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.changePasswordLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                view?.successShowSnackbar("Şifreniz değiştirildi.")
                findNavController().popBackStack()
            }?.doOnFailure {
                view?.failShowSnackbar("Şifre değiştirilemedi. Girdiğiniz şifreleri kontrol ediniz!")
            }
        }
    }

    private fun changePasswordButton() {
        val password = binding.changePasswordOldEt.text.toString().trim()
        val newPassword = binding.changePasswordNewEt.text.toString().trim()

        if (isEligibleToChangePassword(binding, password, newPassword)) {
            viewModel.changePassword(password, newPassword)
        }
    }

    private fun isEligibleToChangePassword(
        binding: FragmentChangePasswordBinding,
        password: String,
        newPassword: String
    ): Boolean {
        if (password.isEmpty()) {
            binding.changePasswordOldEt.error = "Şifre boş olamaz!"
            binding.changePasswordOldEt.requestFocus()
            return false
        }

        if (newPassword.isEmpty() || newPassword.length < 6) {
            binding.changePasswordNewEt.error =
                "Şifrenizi kontrol edin,şifre en az 6 karakter olmalıdır!"
            binding.changePasswordNewEt.requestFocus()
            return false
        }

        if (newPassword == password) {
            view?.failShowSnackbar("Eski şifreniz ve yeni şifreniz aynı. Şifre değiştirmek için yeni şifreniz eski şifrenizden farklı olmalıdır.")
            return false
        }
        return true
    }
}