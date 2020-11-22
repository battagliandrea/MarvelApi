package com.battagliandrea.marvelapi.feature.characters.di

import com.battagliandrea.marvelapi.core.BuildConfig
import com.battagliandrea.marvelapi.core.di.scope.FeatureScope
import com.battagliandrea.marvelapi.feature.characters.data.repository.CharacterRepositoryImpl
import com.battagliandrea.marvelapi.feature.characters.data.retrofit.MarvelApiService
import com.battagliandrea.marvelapi.feature.characters.domain.repository.CharacterRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
internal class CharacterDataModule {

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //          REPOSITORY
    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Provides
    @FeatureScope
    fun provideCharacterRepository(cr: CharacterRepositoryImpl): CharacterRepository = cr

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //          RETROFIT DATASOURCE
    // ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Provides
    @FeatureScope
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): MarvelApiService {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(MarvelApiService::class.java)
    }
}
