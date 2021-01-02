package com.battagliandrea.marvelapi.presentation

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.findNavController
import com.battagliandrea.marvelapi.R
import com.battagliandrea.marvelapi.core.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_frame.*

abstract class NavigationActivity : BaseActivity() {

    private val TAG = this::class.java.name

    @get:NavigationRes
    protected abstract val navGraph: Int

    override val layoutResId: Int = R.layout.activity_frame

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupNavHost(navGraph, navHostFragment)
    }

    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //          NAVIGATION
    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navHostFragment).navigateUp()
    }
}
