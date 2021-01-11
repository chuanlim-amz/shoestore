package com.chuanlim.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chuanlim.shoestore.databinding.FragmentLoginBinding

/**
 * Handle login related stuffs
 */
class LoginFragment : Fragment() {
    private lateinit var binding:FragmentLoginBinding
    private lateinit var args: LoginFragmentArgs
    private var firstTimeUser = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)

        binding.apply {
            username.doOnTextChanged {_, _, _, _ -> loginErrorMsgLabel.isVisible = false }
            password.doOnTextChanged { _, _, _, _ -> loginErrorMsgLabel.isVisible = false  }
            username.doAfterTextChanged { checkToEnableLoginButtonOrNot() }
            password.doAfterTextChanged { checkToEnableLoginButtonOrNot() }
        }

        // Get LoginFragment safeargs
        if(arguments != null) {
            args = LoginFragmentArgs.fromBundle(requireArguments())
            firstTimeUser = args.firstTimeUser
        }

        // Set OnClickListener for Login Button
        binding.login.setOnClickListener {
            checkLoginCredential()
        }

        return binding.root
    }

    /**
     * Enable/disable the 'Sign in' button
     */
    private fun checkToEnableLoginButtonOrNot() {
        binding.apply {
            login.isEnabled = username.text.isNotEmpty() and password.text.isNotEmpty()
        }
    }

    /**
     * Check if the credential is valid or not.
     */
    private fun checkLoginCredential() {
        //TODO: No instruction on what kind of authentication. I just make it simple
        // as long as username and password are not empty, authentication is successful
         binding.apply {
             if(username.text.isNotEmpty() and (password.text.length > 2) ) {
                 //navigate to the next destination
                 Toast.makeText(requireContext(), "Login Successful!!", Toast.LENGTH_SHORT).show()
                 if(firstTimeUser) {
                     findNavController().navigate(
                         LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                     )
                 } else {
                     findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListingFragment())
                 }
             } else {
                 loginErrorMsgLabel.text = "Username or Password is invalid. \nPlease try again"
                 loginErrorMsgLabel.isVisible = true
             }
         }
    }
}