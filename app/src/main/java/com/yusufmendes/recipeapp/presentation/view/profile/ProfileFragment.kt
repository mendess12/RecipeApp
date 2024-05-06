package com.yusufmendes.recipeapp.presentation.view.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.yusufmendes.recipeapp.R
import com.yusufmendes.recipeapp.databinding.FragmentProfileBinding
import com.yusufmendes.recipeapp.util.failShowSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

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
        val uid = FirebaseAuth.getInstance().currentUser?.uid
        if (uid != null) {
            viewModel.getUserData(uid)
        }
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.userDataLiveData.observe(viewLifecycleOwner) {
            it?.doOnSuccess {
                binding.profileEmailTv.text = it.email.toString()
                binding.profileUsernameTv.text = it.username.toString()
            }?.doOnFailure {
                it.message?.let { it1 -> view?.failShowSnackbar(it1) }
            }
        }
    }
}