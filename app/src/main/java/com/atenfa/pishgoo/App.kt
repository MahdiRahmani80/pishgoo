package com.atenfa.pishgoo

import android.app.Application
import android.media.MediaPlayer
import com.atenfa.pishgoo.feature.home.HomeViewModel
import com.atenfa.pishgoo.feature.main.MainViewModel
import com.atenfa.pishgoo.model.repository.DataRepository
import com.atenfa.pishgoo.model.repository.DataRepositoryImpl
import com.atenfa.pishgoo.model.repository.source.shared.SharedPref
import com.atenfa.pishgoo.model.repository.source.shared.SharedPrefImpl
import com.atenfa.pishgoo.utils.Prophecy
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    val modules = module {

      // repository
      single<DataRepository> { DataRepositoryImpl(get()) }

      // classes
      single { createPlayer() }
      single { Prophecy }

      // view model
      factory { HomeViewModel(get()) }
      viewModel { MainViewModel(get()) }

      // local
      single<SharedPref> { SharedPrefImpl() }
    }

    startKoin { modules(modules) }
  }

  private fun createPlayer(): MediaPlayer {
    return MediaPlayer.create(this, R.raw.bg_sound)
  }
}
