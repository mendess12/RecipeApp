package com.yusufmendes.recipeapp.presentation.view.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var binding: FragmentRegisterBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegisterBinding.bind(view)

        binding.registerButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.registerLoginTv.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}