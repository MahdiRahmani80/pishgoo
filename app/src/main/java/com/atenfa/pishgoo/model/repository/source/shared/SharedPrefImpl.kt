package com.atenfa.pishgoo.model.repository.source.shared

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.atenfa.pishgoo.model.data.Data
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SharedPrefImpl : SharedPref {

  private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "shared")

  override suspend fun write(context: Context, data: Data) {
    context.datastore.edit { shared ->
      shared[LAST_PROPHECY_CHECKED_TIME] = data.lastProphecyCheckedTime
      shared[LAST_PROPHECY] = data.lastProphecy
      shared[LAST_MUSIC_STATE] = data.lastMusicState
    }
  }

  override fun read(context: Context):Flow<Data> =
      context.datastore.data.map { shared ->
        val lastProphecyCheckedTime = shared[LAST_PROPHECY_CHECKED_TIME] ?: 0L
        val lastProphecy = shared[LAST_PROPHECY] ?: ""
        val lastMusicState = shared[LAST_MUSIC_STATE] ?: true
        Data(
            lastProphecy = lastProphecy,
            lastMusicState = lastMusicState,
            lastProphecyCheckedTime = lastProphecyCheckedTime)
      }

  companion object {
    private val LAST_PROPHECY_CHECKED_TIME = longPreferencesKey("last_prophecy_checked_time")
    private val LAST_PROPHECY = stringPreferencesKey("last_prophecy")
    private val LAST_MUSIC_STATE = booleanPreferencesKey("last_music_state")
  }
}
