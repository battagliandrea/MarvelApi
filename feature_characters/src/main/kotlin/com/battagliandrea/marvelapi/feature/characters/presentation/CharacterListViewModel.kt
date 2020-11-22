package com.battagliandrea.marvelapi.feature.characters.presentation

import androidx.lifecycle.viewModelScope
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseAction
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseViewModel
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseViewState
import com.battagliandrea.marvelapi.feature.characters.domain.model.CharacterDomainModel
import com.battagliandrea.marvelapi.feature.characters.domain.usecase.GetCharacterListUseCase
import javax.inject.Inject
import kotlinx.coroutines.launch

internal class CharacterListViewModel @Inject constructor(
    private val getCharacterListUseCase: GetCharacterListUseCase
) : BaseViewModel<CharacterListViewModel.ViewState, CharacterListViewModel.Action>(ViewState()) {

    override fun onLoadData() {
        getAlbumList()
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.CharactersLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            characters = viewAction.characters
        )
        is Action.CharactersLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            characters = listOf()
        )
    }

    private fun getAlbumList() {
        viewModelScope.launch {
            getCharacterListUseCase().also {
                if (it.isNotEmpty()) {
                    sendAction(Action.CharactersLoadingSuccess(it))
                } else {
                    sendAction(Action.CharactersLoadingFailure)
                }
            }
        }
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val characters: List<CharacterDomainModel> = listOf()
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class CharactersLoadingSuccess(val characters: List<CharacterDomainModel>) : Action()
        object CharactersLoadingFailure : Action()
    }
}
