package com.atenfa.pishgoo

import android.app.Application
import android.media.MediaPlayer
import com.atenfa.pishgoo.feature.home.HomeViewModel
import com.atenfa.pishgoo.utils.Prophecy
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    val modules = module {
      single { Prophecy }
      // view model
      viewModel { HomeViewModel() }

      single { createPlayer() }
    }

    startKoin { modules(modules) }
  }

  private fun createPlayer(): MediaPlayer {
    return MediaPlayer.create(this, R.raw.bg_sound)
  }
}
