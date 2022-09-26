package com.example.alphaacemobile.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.example.alphaacemobile.R
import com.example.alphaacemobile.databinding.FragmentSignupBinding

class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(layoutInflater, container, false)

        //SharedPreference
        preferences = requireActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
        editor = preferences.edit()

        binding.apply {
            // TextLayout Signup Email
            tietSignupEmail.doOnTextChanged { text, start, before, count ->
                if (text!!.isEmpty()) {
                    tilSignupEmail.error = "Required"
                } else {
                    tilSignupEmail.error = null
                }
            }

            // TextLayout Signup Password
            tietSignupPassword.doOnTextChanged { text, start, before, count ->
                if (text!!.isEmpty()) {
                    tilSignupPassword.error = "Required"
                } else {
                    tilSignupPassword.error = null
                }
            }

            // Button Signup Confirm
            btnSignupConfirm.setOnClickListener {
                if (tietSignupEmail.text.toString().isEmpty()) {
                    Toast.makeText(context, "Email is required", Toast.LENGTH_SHORT).show()
                } else if (tietSignupPassword.text.toString().isEmpty()) {
                    Toast.makeText(context, "Password is required", Toast.LENGTH_SHORT).show()
                } else {
                    editor.apply {
                        putString("email", tietSignupEmail.text.toString())
                        putString("password", tietSignupPassword.text.toString())
                        commit()
                    }
                    Toast.makeText(context, "Account Created!!!", Toast.LENGTH_SHORT).show()
                    requireActivity().onBackPressed()
                }
            }

            // Button Login
            btnSignupLogin.setOnClickListener {
                requireActivity().onBackPressed()
                findNavController().navigate(R.id.loginFragment)
            }

            return root
        }
    }
}