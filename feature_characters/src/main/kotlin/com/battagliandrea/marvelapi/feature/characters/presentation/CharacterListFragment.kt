package com.battagliandrea.marvelapi.feature.characters.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.battagliandrea.marvelapi.core.presentation.BaseFragment
import com.battagliandrea.marvelapi.core.presentation.extensions.observe
import com.battagliandrea.marvelapi.feature.characters.R
import com.battagliandrea.marvelapi.feature.characters.di.CharacterComponent
import com.battagliandrea.marvelapi.feature.characters.di.CharacterInjector
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_character_list.*

class CharacterListFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: CharacterListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CharacterInjector.initialize(applicationContext = requireActivity().application)
        CharacterComponent.INSTANCE.inject(this)
    }

    @Inject
    internal lateinit var characterAdapter: CharacterAdapter

    override val layoutResourceId: Int = R.layout.fragment_character_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory)[CharacterListViewModel::class.java]

        characterAdapter.setOnDebouncedClickListener {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
        }

        recyclerView.apply {
            setHasFixedSize(true)

            layoutManager = GridLayoutManager(context, 2)
            adapter = characterAdapter
        }

        observe(mViewModel.stateLiveData, ::onStateChange)
        mViewModel.loadData()
    }

    private fun onStateChange(state: CharacterListViewModel.ViewState) {
        characterAdapter.characters = state.characters
    }
}
