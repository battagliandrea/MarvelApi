package com.battagliandrea.marvelapi.feature.characters.di

import android.app.Application
import com.battagliandrea.marvelapi.MarvelApiApplication

object CharacterInjector {

    fun initialize(applicationContext: Application) {
        val coreComponent = (applicationContext as? MarvelApiApplication)?.coreComponent
                ?: throw IllegalStateException("Provider not implemented: $applicationContext")

        val featureComponent = DaggerCharacterComponent
            .factory()
            .create(coreComponent)
        CharacterComponent.INSTANCE = featureComponent
    }
}
