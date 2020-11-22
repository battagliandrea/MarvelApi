package com.battagliandrea.marvelapi

import com.battagliandrea.marvelapi.core.MarvelApiCoreApplication
import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.di.AppComponent
import com.battagliandrea.marvelapi.di.DaggerAppComponent

class MarvelApiApplication : MarvelApiCoreApplication() {

    companion object {

        lateinit var instance: MarvelApiApplication
            private set

        val appComponent: AppComponent
            get() = AppComponent.INSTANCE
    }

    override fun initializeAppComponent(coreComponent: CoreComponent) {
        AppComponent.INSTANCE = buildAppComponent(coreComponent)
    }

    private fun buildAppComponent(coreComponent: CoreComponent): AppComponent {
        return DaggerAppComponent.factory().create(this, coreComponent)
    }
}
