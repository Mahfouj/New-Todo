package com.example.toodo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentSingBinding

class SingFragment :BaseFragment<FragmentSingBinding>(FragmentSingBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.btnNext.setOnClickListener {

        findNavController().navigate(R.id.action_singFragment_to_loginFragment)
    }
     binding.btnArrowLeft.setOnClickListener {
         findNavController().navigate(R.id.action_singFragment_to_login_Singup)
     }


    }




}