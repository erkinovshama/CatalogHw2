package com.itacademy.cataloghw.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itacademy.cataloghw.HomeActivity
import com.itacademy.cataloghw.databinding.FragmentLoginBinding
import com.itacademy.cataloghw.services.SharedPreference

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val sharedPref = context?.let { SharedPreference(it) }
        if (sharedPref?.login != "" && sharedPref?.password != "") {
            if (!sharedPref?.login.isNullOrBlank() && !sharedPref?.password.isNullOrBlank()) 
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
            }

            _binding = FragmentLoginBinding.inflate(inflater, container, false)

            binding.saveBtn.setOnClickListener {
                sharedPref?.login = binding.loginEdittext.text.toString()
                sharedPref?.password = binding.passwordEdittext.text.toString()
                startActivity(Intent(requireActivity(), HomeActivity::class.java))
            }

            binding.getBtn.setOnClickListener {
                val arg =
                    requireActivity().getSharedPreferences("SharedPreference", Context.MODE_PRIVATE)
                        ?.apply {
                            val login = getString("login", null)
                            val password = getString("password", null)

                            binding.loginEdittext.setText(login)
                            binding.passwordEdittext.setText(password)
                        }
            }
            return binding.root
        }
    }