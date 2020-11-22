package com.battagliandrea.marvelapi.feature.bookmarks.di

import android.app.Application
import com.battagliandrea.marvelapi.MarvelApiApplication

object BookmarksInjector {

    fun initialize(applicationContext: Application) {
        val coreComponent = (applicationContext as? MarvelApiApplication)?.coreComponent
                ?: throw IllegalStateException("Provider not implemented: $applicationContext")

        val featureComponent = DaggerBookmarksComponent.factory().create(coreComponent)
        BookmarksComponent.INSTANCE = featureComponent
    }
}
