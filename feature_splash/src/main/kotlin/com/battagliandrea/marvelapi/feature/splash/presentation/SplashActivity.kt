package com.battagliandrea.marvelapi.feature.splash.presentation

import android.os.Bundle
import androidx.navigation.findNavController
import com.battagliandrea.marvelapi.R as ResApp
import com.battagliandrea.marvelapi.core.presentation.BaseActivity
import com.battagliandrea.marvelapi.feature.splash.R as ResSplash
import com.battagliandrea.marvelapi.presentation.extensions.setupNavHost
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private val navGraph: Int = ResApp.navigation.feature_splash_nav_graph

    override val layoutResId: Int = ResSplash.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavHost(navGraph, navHostFragment)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(ResSplash.id.navHostFragment).navigateUp()
    }
}
