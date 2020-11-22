package com.battagliandrea.marvelapi.di

import android.content.Context
import com.battagliandrea.marvelapi.core.di.CoreComponent
import com.battagliandrea.marvelapi.core.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
        modules = [],
        dependencies = [
            CoreComponent::class
        ]
)
interface AppComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: AppComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            coreComponent: CoreComponent
        ): AppComponent
    }

//    fun inject(activity: MainActivity)
}
