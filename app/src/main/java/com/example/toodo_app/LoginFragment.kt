package com.example.toodo_app

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.toodo_app.base.BaseFragment
import com.example.toodo_app.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    lateinit var firebaseUser: FirebaseUser


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       binding.btnArrowLeft.setOnClickListener {
           findNavController().navigate(R.id.action_loginFragment_to_login_Singup)
       }

       binding.txtConfirmation.setOnClickListener {
           findNavController().navigate(R.id.action_loginFragment_to_singFragment)
       }

         binding.password.setOnClickListener {
             findNavController().navigate(R.id.action_loginFragment_to_forgetpasswordFragment)
         }


        binding.btnNext.setOnClickListener {
            val Email = binding.etEmail.text.toString().trim()
            val Password = binding.etPassword.text.toString().trim()
            if (isEmailValid(Email) && isPasswordValid(Password)) {
         
                loginUser(Email, Password,)
         
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

    private fun loginUser(email: String, password: String) {

        val auth=FirebaseAuth.getInstance()


        auth.signInWithEmailAndPassword(email,password).

        addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val user = auth.currentUser

                Toast.makeText(context, "Login Successful: ${user?.email}", Toast.LENGTH_SHORT)
                    .show()

                findNavController().navigate(R.id.action_loginFragment_to_homesFragment )



            } else {
                Toast.makeText(context,"Login Failed:${task.exception?.message}",Toast.LENGTH_SHORT).show()


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