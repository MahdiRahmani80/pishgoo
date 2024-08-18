package com.atenfa.pishgoo.model.repository

import android.content.Context
import com.atenfa.pishgoo.model.data.Data
import kotlinx.coroutines.flow.Flow

interface DataRepository {

  suspend fun write(context: Context,data: Data)

  fun read(context: Context): Flow<Data>
}
