package com.atenfa.pishgoo.common.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

abstract class BaseActivity :
    AppCompatActivity(), PishgooView, CoroutineScope by CoroutineScope(Dispatchers.Main) {

  private lateinit var navController: NavController

  override fun showSnackBar(view: View, message: String, length: Int) {
    val bar = Snackbar.make(view, message, length)
    bar.view.layoutDirection = View.LAYOUT_DIRECTION_RTL
    bar.show()
  }

  fun makeNavigation(navHostId: Int): NavController {
    val navHostFragment = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
    return navHostFragment.navController
  }

  override fun onSupportNavigateUp(): Boolean {
    return navController.navigateUp() || super.onSupportNavigateUp()
  }

  override fun onDestroy() {
    coroutineContext[Job]?.cancel()
    super.onDestroy()
  }
}
