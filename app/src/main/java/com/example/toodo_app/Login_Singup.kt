package com.example.toodo_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.databinding.FragmentLoginSingupBinding


class Login_Singup : Fragment() {


 lateinit var binding: FragmentLoginSingupBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentLoginSingupBinding.inflate(inflater,container,false)

        binding.btnSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_login_Singup_to_singFragment)
        }

        return(binding.root)
    }

}