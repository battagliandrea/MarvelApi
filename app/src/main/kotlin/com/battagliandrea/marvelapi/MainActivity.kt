package com.battagliandrea.marvelapi

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.battagliandrea.marvelapi.core.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_frame_bottom_nav.*

class MainActivity : BaseActivity() {

    override val layoutResId = R.layout.activity_frame_bottom_nav

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = navHostFragment.findNavController()
        bottomNavigationView.setupWithNavController(navController)
    }
}
