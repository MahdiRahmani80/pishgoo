package com.atenfa.pishgoo.model.repository

import android.content.Context
import com.atenfa.pishgoo.model.data.Data
import com.atenfa.pishgoo.model.repository.source.shared.SharedPref
import kotlinx.coroutines.flow.Flow

class DataRepositoryImpl(private val sharedPref: SharedPref) : DataRepository {

  override suspend fun write(context: Context, data: Data) {
    sharedPref.write(context, data)
  }

  override fun read(context: Context): Flow<Data> {
    return sharedPref.read(context)
  }
}
