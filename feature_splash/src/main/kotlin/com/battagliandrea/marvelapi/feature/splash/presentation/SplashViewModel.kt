package com.battagliandrea.marvelapi.feature.splash.presentation

import androidx.lifecycle.viewModelScope
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseAction
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseViewModel
import com.battagliandrea.marvelapi.core.presentation.viewmodel.BaseViewState
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

internal class SplashViewModel @Inject constructor() : BaseViewModel<SplashViewModel.ViewState, SplashViewModel.Action>(ViewState()) {

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.TimeoutSuccess -> state.copy(
            waiting = false
        )
    }

    fun startTimeout() {
        viewModelScope.launch {
            delay(2000)
            sendAction(Action.TimeoutSuccess)
        }
    }

    internal data class ViewState(
        val waiting: Boolean = true
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        object TimeoutSuccess : Action()
    }
}
