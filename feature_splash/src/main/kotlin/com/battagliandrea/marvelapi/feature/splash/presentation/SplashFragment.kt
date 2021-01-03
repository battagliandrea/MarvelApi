package com.battagliandrea.marvelapi.feature.splash.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.battagliandrea.marvelapi.core.presentation.BaseFragment
import com.battagliandrea.marvelapi.core.presentation.extensions.observe
import com.battagliandrea.marvelapi.feature.splash.R
import com.battagliandrea.marvelapi.feature.splash.di.SplashComponent
import com.battagliandrea.marvelapi.feature.splash.di.SplashInjector
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_splash.*

class SplashFragment @Inject constructor() : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: SplashViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        SplashInjector.initialize(applicationContext = requireActivity().application)
        SplashComponent.INSTANCE.inject(this)
    }

    override val layoutResourceId = R.layout.fragment_splash

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProviders.of(this, viewModelFactory)[SplashViewModel::class.java]

        observe(mViewModel.stateLiveData, ::onStateChange)
        mViewModel.startTimeout()

        startAnimation()
    }

    private fun onStateChange(state: SplashViewModel.ViewState) {
        if (!state.waiting) {
            findNavController().navigate(com.battagliandrea.marvelapi.R.id.action_splashFragment_to_homeActivity)
            activity?.finish()
        }
    }

    private fun startAnimation() {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        alphaAnimation.duration = 1000
        alphaAnimation.fillAfter = true
        alphaAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
            }

            override fun onAnimationStart(p0: Animation?) {
                container.visibility = View.VISIBLE
            }
        })
        container.startAnimation(alphaAnimation)
    }
}
