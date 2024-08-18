package com.atenfa.pishgoo.feature.main

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.common.base.BaseActivity
import com.atenfa.pishgoo.common.viewbinding.viewBinding
import com.atenfa.pishgoo.databinding.ActivityMainBinding
import com.atenfa.pishgoo.utils.Constant.SPLASH_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

  private val binding: ActivityMainBinding by viewBinding()
  private lateinit var navController: NavController

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
    navController = makeNavigation(binding.navHostFragment.id)
    showSplash()
    playSongInBackground()
  }

  private fun showSplash() {
    launch {
      delay(SPLASH_DURATION)
      binding.navHostFragment.visibility = View.VISIBLE
      if (navController.currentDestination?.id != R.id.homeFragment) {
        navController.navigate(R.id.action_splashFragment_to_homeFragment)
      }
    }
  }
}
