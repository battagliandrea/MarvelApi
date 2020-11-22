package com.battagliandrea.marvelapi.feature.characters.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelFactory
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelKey
import com.battagliandrea.marvelapi.feature.characters.presentation.CharacterListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class CharacterModule {

    @Binds
    abstract fun bindViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DaggerViewModelKey(CharacterListViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: CharacterListViewModel): ViewModel
}
