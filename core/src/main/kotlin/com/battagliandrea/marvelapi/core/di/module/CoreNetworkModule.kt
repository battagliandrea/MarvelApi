package com.battagliandrea.marvelapi.core.di.module

import com.battagliandrea.marvelapi.core.BuildConfig
import com.battagliandrea.marvelapi.core.data.retrofit.AuthInterceptor
import com.battagliandrea.marvelapi.core.di.scope.FeatureScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class CoreNetworkModule {

    // /////////////////////////////////
    //          OKHTTP
    // /////////////////////////////////
    @Provides
    @FeatureScope
    fun provideOkHttp(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }

        val authInterceptor = AuthInterceptor()

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(authInterceptor)
                .build()
    }

    // /////////////////////////////////
    //          GSON
    // /////////////////////////////////
    @Provides
    @FeatureScope
    fun provideGson(): Gson = Gson()
}
