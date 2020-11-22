package com.battagliandrea.marvelapi.feature.bookmarks.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class BookmarkListViewModel @Inject constructor() : ViewModel() {

    private val _viewState = MutableLiveData<BookmarkListViewState>()
    val viewState: LiveData<BookmarkListViewState> = _viewState
}
