package com.battagliandrea.marvelapi.feature.bookmarks.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.battagliandrea.marvelapi.core.presentation.BaseFragment
import com.battagliandrea.marvelapi.core.presentation.extensions.observe
import com.battagliandrea.marvelapi.feature.bookmarks.R
import com.battagliandrea.marvelapi.feature.bookmarks.di.BookmarksComponent
import com.battagliandrea.marvelapi.feature.bookmarks.di.BookmarksInjector
import javax.inject.Inject

class BookmarkListFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: BookmarkListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        BookmarksInjector.initialize(requireActivity().application)
        BookmarksComponent.INSTANCE.inject(this)
    }

    override val layoutResourceId: Int = R.layout.fragment_bookmark_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory)[BookmarkListViewModel::class.java]

        with(mViewModel) {
            observe(viewState) { }
        }
    }
}
