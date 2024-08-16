package com.atenfa.pishgoo

import android.app.Application
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

  override fun onCreate() {
    super.onCreate()

    val modules = module {

      // view model
      // local
      // remote
      // repository
      // data source
    }

    startKoin { modules(modules) }
  }
}
