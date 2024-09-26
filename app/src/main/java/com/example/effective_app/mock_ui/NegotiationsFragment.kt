package com.example.effective_app.mock_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.effective_app.databinding.FragmentNegotiationsBinding

class NegotiationsFragment : Fragment() {
    private lateinit var binding: FragmentNegotiationsBinding

    override
    fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNegotiationsBinding.inflate(layoutInflater)
        return binding.root
    }
}