package com.example.toodo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentForgetpasswordBinding

class ForgetpasswordFragment :BaseFragment<FragmentForgetpasswordBinding>(FragmentForgetpasswordBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_forgetpasswordFragment_to_loginFragment)
        }
    }

}