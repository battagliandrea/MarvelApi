package com.battagliandrea.marvelapi.feature.characters.domain.usecase

import com.battagliandrea.marvelapi.feature.characters.domain.repository.CharacterRepository
import javax.inject.Inject

internal class GetCharacterListUseCase @Inject constructor(
    private val characterRepository: CharacterRepository
) {
    suspend operator fun invoke() = characterRepository.get()
}
