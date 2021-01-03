package com.battagliandrea.marvelapi.feature.home.di

import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.core.di.scope.FeatureScope
import dagger.Component

@FeatureScope
@Component(
        modules = [HomeModule::class],
        dependencies = [CoreComponent::class]
)
interface HomeComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: HomeComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): HomeComponent
    }
}
