package com.battagliandrea.marvelapi.di

import android.app.Application
import com.battagliandrea.marvelapi.core.di.CoreComponent

object AppInjector {

    fun initialize(application: Application, coreComponent: CoreComponent) {
        AppComponent.INSTANCE = DaggerAppComponent.factory().create(application, coreComponent)
    }
}
