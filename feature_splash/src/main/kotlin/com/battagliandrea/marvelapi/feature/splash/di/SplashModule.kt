package com.battagliandrea.marvelapi.feature.splash.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelFactory
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelKey
import com.battagliandrea.marvelapi.feature.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class SplashModule {

    @Binds
    abstract fun bindViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DaggerViewModelKey(SplashViewModel::class)
    abstract fun bindCharacterListViewModel(viewModel: SplashViewModel): ViewModel
}
