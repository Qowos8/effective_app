package com.example.feature_authorize

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.feature_authorize.databinding.FragmentAuthBinding

class AuthFragment: Fragment() {
    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(layoutInflater)
        binding.authBlock.textField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.authBlock.continueButton.isEnabled = s.toString().isNotEmpty()

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        })
        return binding.root
    }

    fun isValidEmail(email: CharSequence): Boolean {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun FragmentAuthBinding.buttonEnable(){
        authBlock.apply {
            continueButton.setOnClickListener {
                val email = textField.text.toString().trim()
                if (!isValidEmail(email)) {
                    inputLayout.error = "Неправильный формат email"
                } else {
                    inputLayout.error = null
                }
            }
        }
    }
}