package com.example.toodo_app

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentSingBinding
import com.google.firebase.auth.FirebaseAuth

class SingFragment :BaseFragment<FragmentSingBinding>(FragmentSingBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNext.setOnClickListener {

            val Password = binding.etPassword.text.toString().trim()
            val FastName = binding.FirstName.text.toString().trim()
            val Email = binding.etEmail.text.toString().trim()

            if (isEmailValid(Email) && isPasswordValid(Password)) {

                registerUser(Email, Password, FastName)

            } else {
                Toast.makeText(
                    requireContext(),
                    "Invalid email or Password ",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }


        }

    }

    private fun registerUser(Email: String, Password: String, FastName: String) {

        val auth = FirebaseAuth.getInstance()

        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener { task ->
            if (task.isSuccessful) {

                findNavController().navigate(R.id.action_singFragment_to_loginFragment)

            } else {
                Toast.makeText(
                    context,
                    "Login Failed:${task.exception?.message}", Toast.LENGTH_SHORT
                )
                    .show()


            }
        }


    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        val passwordRegex =
            "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$".toRegex()

        return if (password.matches(passwordRegex)) {
            true
        } else {
            showPasswordValidationError()
            false
        }


    }

    private fun showPasswordValidationError() {
         Toast.makeText(context,"Password must be at least 8 characters long and include " +
                 "at least one letter, one number, and one special character.",Toast.LENGTH_LONG).show()
    }

}