package com.atenfa.pishgoo.feature.main

import android.os.Bundle
import androidx.navigation.NavController
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.common.base.BaseActivity
import com.atenfa.pishgoo.common.viewbinding.viewBinding
import com.atenfa.pishgoo.databinding.ActivityMainBinding
import com.atenfa.pishgoo.utils.Constant.SPLASH_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.core.component.inject

class MainActivity : BaseActivity() {

  private val binding: ActivityMainBinding by viewBinding()
  private lateinit var navController: NavController
  private val viewModel by inject<MainViewModel>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    navController = makeNavigation(binding.navHostFragment.id)
    showSplash()

    launch {
      viewModel.getData(this@MainActivity).collect {
        it
        if (it.lastMusicState) playSongInBackground()
      }
    }
  }

  private fun showSplash() {
    launch {
      delay(SPLASH_DURATION)
      if (navController.currentDestination?.id != R.id.homeFragment) {
        navController.navigate(R.id.action_splashFragment_to_homeFragment)
      }
    }
  }
}
