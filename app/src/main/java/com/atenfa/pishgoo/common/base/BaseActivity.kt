package com.atenfa.pishgoo.common.base

import android.media.MediaPlayer
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseActivity :
    AppCompatActivity(), PishgooView, CoroutineScope by CoroutineScope(Dispatchers.Main) {

  private lateinit var navController: NavController
  private var player: MediaPlayer? = null

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
    player?.stop()
    player?.release()
    super.onDestroy()
  }

  // song setting
  fun playSongInBackground(bgSound: Int) {
    if (player == null) {
      player = MediaPlayer.create(this, bgSound)
    }
    player!!.start()
    player!!.isLooping = true
  }

  fun stopSongInBackground() {
    player?.stop()
  }

  override fun onStop() {
    player?.pause()
    super.onStop()
  }

  override fun onStart() {
    player?.start()
    super.onStart()
  }
}
