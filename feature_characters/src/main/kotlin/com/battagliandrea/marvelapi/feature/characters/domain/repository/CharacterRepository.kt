package com.battagliandrea.marvelapi.feature.characters.domain.repository

import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel

internal interface CharacterRepository {

    suspend fun get(): List<CharacterDomainModel>
}
