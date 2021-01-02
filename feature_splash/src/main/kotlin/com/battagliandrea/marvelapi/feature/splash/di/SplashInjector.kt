package com.battagliandrea.marvelapi.feature.splash.di

import android.app.Application
import com.battagliandrea.marvelapi.MarvelApiApplication

object SplashInjector {

    fun initialize(applicationContext: Application) {
        val coreComponent = (applicationContext as? MarvelApiApplication)?.coreComponent
                ?: throw IllegalStateException("Provider not implemented: $applicationContext")

        val featureComponent = DaggerSplashComponent
            .factory()
            .create(coreComponent)
        SplashComponent.INSTANCE = featureComponent
    }
}
