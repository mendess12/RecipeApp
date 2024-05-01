package com.yusufmendes.recipeapp.presentation.view.changepassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentChangePasswordBinding
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
                Snackbar.make(requireView(), "Şifreniz değiştirildi.", Snackbar.LENGTH_SHORT).show()
                findNavController().popBackStack()
            }?.doOnFailure {
                Snackbar.make(
                    requireView(),
                    "Şifre değiştirilemedi. Girdiğiniz şifreleri kontrol ediniz!",
                    Snackbar.LENGTH_SHORT
                ).show()
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
            Snackbar.make(
                requireView(),
                "Eski şifreniz ve yeni şifreniz aynı. Şifre değiştirmek için yeni şifreniz eski şifrenizden farklı olmalıdır.",
                Snackbar.LENGTH_SHORT
            ).show()
            return false
        }
        return true
    }
}