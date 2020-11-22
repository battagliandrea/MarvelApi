package com.battagliandrea.marvelapi.feature.characters.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.battagliandrea.marvelapi.core.presentation.BaseFragment
import com.battagliandrea.marvelapi.core.presentation.extensions.observe
import com.battagliandrea.marvelapi.feature.characters.R
import com.battagliandrea.marvelapi.feature.characters.di.CharacterComponent
import com.battagliandrea.marvelapi.feature.characters.di.CharacterInjector
import javax.inject.Inject

class CharacterListFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: CharacterListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CharacterInjector.initialize(applicationContext = requireActivity().application)
        CharacterComponent.INSTANCE.inject(this)
    }

    override val layoutResourceId: Int = R.layout.fragment_character_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = ViewModelProviders.of(this, viewModelFactory)[CharacterListViewModel::class.java]

        observe(mViewModel.stateLiveData, ::onStateChange)
        mViewModel.loadData()
    }

    private fun onStateChange(state: CharacterListViewModel.ViewState) {
        Toast.makeText(context, state.characters.count().toString(), Toast.LENGTH_SHORT).show()
    }
}
