package com.battagliandrea.marvelapi.feature.splash.presentation

import android.os.Bundle
import com.battagliandrea.marvelapi.R
import com.battagliandrea.marvelapi.presentation.NavigationActivity

class SplashActivity : NavigationActivity() {

    override val navGraph: Int = R.navigation.feature_splash_nav_graph

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
