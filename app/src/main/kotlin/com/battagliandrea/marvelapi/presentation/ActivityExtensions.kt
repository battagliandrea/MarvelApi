package com.battagliandrea.marvelapi.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment

/**
 * Set navigation programmatically
 */
fun AppCompatActivity.setupNavHost(navGraph: Int, navHostFragment: Fragment) {
    val myNavHostFragment: NavHostFragment = navHostFragment as NavHostFragment
    val inflater = myNavHostFragment.navController.navInflater
    val graph = inflater.inflate(navGraph)
    myNavHostFragment.navController.graph = graph
}
