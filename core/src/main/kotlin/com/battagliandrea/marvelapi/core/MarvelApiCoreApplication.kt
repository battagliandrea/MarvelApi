package com.battagliandrea.marvelapi.core

import android.app.Application
import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.core.di.CoreInjector

abstract class MarvelApiCoreApplication : Application() {

    val coreComponent: CoreComponent
        get() = CoreComponent.INSTANCE

    override fun onCreate() {
        super.onCreate()
        val coreComponent = initializeCoreComponent()
        initializeAppComponent(coreComponent)
    }

    protected abstract fun initializeAppComponent(coreComponent: CoreComponent)

    private fun initializeCoreComponent(): CoreComponent {
        CoreInjector.initialize(this)
        return coreComponent
    }
}
