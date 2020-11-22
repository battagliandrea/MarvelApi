package com.battagliandrea.marvelapi.feature.bookmarks.di

import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.feature.bookmarks.presentation.BookmarkListFragment
import dagger.Component

@BookmarksScope
@Component(
        modules = [BookmarksModule::class],
        dependencies = [CoreComponent::class]
)

interface BookmarksComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: BookmarksComponent
    }

    @Component.Factory
    interface Factory {
        fun create(appComponent: CoreComponent): BookmarksComponent
    }

    fun inject(fragment: BookmarkListFragment)
}
