package com.atenfa.pishgoo.feature.splash

import android.os.Bundle
import android.view.View
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.common.base.BaseFragment
import com.atenfa.pishgoo.databinding.FragmentSplashBinding
import viewBinding

class SplashFragment() : BaseFragment(R.layout.fragment_splash) {

  private val binding by viewBinding(FragmentSplashBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.root
  }
}
