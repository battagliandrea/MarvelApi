package com.battagliandrea.marvelapi.feature.bookmarks.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelFactory
import com.battagliandrea.marvelapi.core.di.vm.DaggerViewModelKey
import com.battagliandrea.marvelapi.feature.bookmarks.presentation.BookmarkListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class BookmarksModule {

    @Binds
    abstract fun bindViewModelFactory(factoryDagger: DaggerViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @DaggerViewModelKey(BookmarkListViewModel::class)
    abstract fun bindBookmarkListViewModel(viewModel: BookmarkListViewModel): ViewModel
}
