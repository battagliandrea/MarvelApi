package com.battagliandrea.marvelapi.feature.characters.presentation

import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel

internal sealed class CharacterListViewState {
    object Initialized : CharacterListViewState()
    object Loading : CharacterListViewState()

    class CharactersLoadingSuccess(val albums: List<CharacterDomainModel>) : CharacterListViewState()
    object CharactersLoadingFailure : CharacterListViewState()
}
