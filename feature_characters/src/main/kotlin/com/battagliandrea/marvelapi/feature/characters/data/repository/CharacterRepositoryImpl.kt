package com.battagliandrea.marvelapi.feature.characters.data.repository

import com.battagliandrea.marvelapi.feature.characters.data.model.toDomainModels
import com.battagliandrea.marvelapi.feature.characters.data.retrofit.MarvelApiService
import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel
import com.battagliandrea.marvelapi.feature.characters.domain.repository.CharacterRepository
import javax.inject.Inject

internal class CharacterRepositoryImpl @Inject constructor(
    private val marvelApiService: MarvelApiService
) : CharacterRepository {

    override suspend fun get(): List<CharacterDomainModel> {
        val response = marvelApiService.getCharacters(25, 0)
        return if (response.isSuccessful) {
            response.body()?.data?.results?.toDomainModels().orEmpty() // TODO: handle error
        } else {
            // TODO: handle error
            emptyList()
        }
    }
}
