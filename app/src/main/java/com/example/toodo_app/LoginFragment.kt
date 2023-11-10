package com.example.toodo_app

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btnArrowLeft.setOnClickListener {
           findNavController().navigate(R.id.action_loginFragment_to_login_Singup)
       }

       binding.btnNext.setOnClickListener {

           findNavController().navigate(R.id.action_loginFragment_to_homesFragment)

           }

       binding.txtConfirmation.setOnClickListener {

           findNavController().navigate(R.id.action_loginFragment_to_singFragment)

       }

         binding.password.setOnClickListener {

             findNavController().navigate(R.id.action_loginFragment_to_forgetpasswordFragment)

         }

    }



}