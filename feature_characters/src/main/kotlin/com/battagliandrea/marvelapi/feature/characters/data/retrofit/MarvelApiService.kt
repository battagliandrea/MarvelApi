package com.battagliandrea.marvelapi.feature.characters.data.retrofit

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MarvelApiService {

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<GetCharactersResponse>
}
