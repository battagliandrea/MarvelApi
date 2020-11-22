package com.battagliandrea.marvelapi.core.di

import android.content.Context
import com.battagliandrea.marvelapi.core.di.module.CoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = [CoreModule::class]
)
interface CoreComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: CoreComponent
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): CoreComponent
    }
}
