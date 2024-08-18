package com.atenfa.pishgoo.feature.main

import android.content.Context
import com.atenfa.pishgoo.common.base.BaseViewModel
import com.atenfa.pishgoo.model.repository.DataRepository

class MainViewModel(private val repository: DataRepository) : BaseViewModel() {

  fun getData(context: Context) = repository.read(context)
}
