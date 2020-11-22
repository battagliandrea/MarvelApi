package com.battagliandrea.marvelapi.feature.bookmarks.presentation

sealed class BookmarkListViewState {
    object Initialized : BookmarkListViewState()
    object Loading : BookmarkListViewState()
}
