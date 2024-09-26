package com.example.effective_app

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.effective_app.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setOnItemSelectedListener { item ->
            val currentFragmentId = navController.currentDestination?.id

            val authFragmentId = R.id.auth_fragment

            if (currentFragmentId == authFragmentId) {
                return@setOnItemSelectedListener false
            }

            when (item.itemId) {
                R.id.profile -> {
                    navController.navigate(R.id.profile)
                    true
                }
                R.id.message -> {
                    navController.navigate(R.id.message)
                    true
                }
                R.id.negotiations -> {
                    navController.navigate(R.id.negotiations)
                    true
                }
                R.id.search -> {
                    navController.navigate(R.id.search)
                    true
                }
                R.id.favorites -> {
                    navController.navigate(R.id.favorites)
                    true
                }
                else -> false
            }
        }
    }
}