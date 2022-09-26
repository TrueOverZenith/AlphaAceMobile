package com.example.alphaacemobile.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.alphaacemobile.R
import com.example.alphaacemobile.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var preferences: SharedPreferences
    private lateinit var editor : SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        // SharedPreference
        preferences = requireActivity().getSharedPreferences("shared_pref", Context.MODE_PRIVATE)

        editor = preferences.edit()

        binding.apply {

            // Button Login Confirm
            btnLoginConfirm.setOnClickListener {
                if ((tietLoginEmail.text.toString() != "admin") || (tietLoginPassword.text.toString() != "admin")){
                    Toast.makeText(context, "Invalid account or password", Toast.LENGTH_SHORT).show()
                } else {
                    editor.apply {
                        putString("email", "admin")
                        putString("password", "admin")
                        commit()
                    }
                    requireActivity().onBackPressed()
                }
            }

            // TextView Forget Password
            tvLoginForget.setOnClickListener() {
                requireActivity().onBackPressed()
                findNavController().navigate(R.id.forgetPasswordFragment)
            }

            // TextView Signup
            btnLoginSignup.setOnClickListener {
                requireActivity().onBackPressed()
                findNavController().navigate(R.id.signupFragment)
            }

            return root
        }
    }
}