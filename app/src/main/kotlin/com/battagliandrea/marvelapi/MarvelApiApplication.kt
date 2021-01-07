package com.battagliandrea.marvelapi

import com.battagliandrea.marvelapi.core.MarvelApiCoreApplication
import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.di.AppInjector

class MarvelApiApplication : MarvelApiCoreApplication() {

    override fun initializeAppComponent(coreComponent: CoreComponent) {
        AppInjector.initialize(this, coreComponent)
    }
}
