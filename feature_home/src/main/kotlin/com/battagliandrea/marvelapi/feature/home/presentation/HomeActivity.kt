package com.battagliandrea.marvelapi.feature.home.presentation

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.battagliandrea.marvelapi.core.presentation.BaseActivity
import com.battagliandrea.marvelapi.feature.home.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    override val layoutResId = R.layout.activity_home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = navHostFragment.findNavController()
        bottomNavigationView.setupWithNavController(navController)
    }
}
