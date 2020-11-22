package com.battagliandrea.marvelapi.feature.characters.di

import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.core.di.module.CoreNetworkModule
import com.battagliandrea.marvelapi.core.di.scope.FeatureScope
import com.battagliandrea.marvelapi.feature.characters.presentation.CharacterListFragment
import dagger.Component

@FeatureScope
@Component(
        modules = [CoreNetworkModule::class, CharacterModule::class, CharacterDataModule::class],
        dependencies = [CoreComponent::class]
)
interface CharacterComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: CharacterComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): CharacterComponent
    }

    fun inject(fragment: CharacterListFragment)
}
