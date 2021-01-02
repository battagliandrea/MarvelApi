package com.battagliandrea.marvelapi.feature.splash.di

import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.core.di.scope.FeatureScope
import com.battagliandrea.marvelapi.feature.splash.presentation.SplashFragment
import dagger.Component

@FeatureScope
@Component(
        modules = [SplashModule::class],
        dependencies = [CoreComponent::class]
)
interface SplashComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: SplashComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): SplashComponent
    }

    fun inject(fragment: SplashFragment)
}
