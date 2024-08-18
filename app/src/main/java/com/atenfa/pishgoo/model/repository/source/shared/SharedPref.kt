package com.atenfa.pishgoo.model.repository.source.shared

import android.content.Context
import com.atenfa.pishgoo.model.data.Data
import kotlinx.coroutines.flow.Flow

interface SharedPref {

    fun read(context: Context): Flow<Data>
    suspend fun write(context: Context, data: Data)
}
