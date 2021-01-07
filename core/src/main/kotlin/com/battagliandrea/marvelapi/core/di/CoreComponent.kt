package com.battagliandrea.marvelapi.core.di

import android.content.Context
import com.battagliandrea.marvelapi.core.di.module.CoreModule
import com.battagliandrea.marvelapi.core.di.module.CoreNetworkModule
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import okhttp3.OkHttpClient

@Singleton
@Component(
        modules = [CoreModule::class, CoreNetworkModule::class]
)
interface CoreComponent {

    companion object {
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: CoreComponent
    }

    fun getGson(): Gson

    fun getOkhttp(): OkHttpClient

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): CoreComponent
    }
}
