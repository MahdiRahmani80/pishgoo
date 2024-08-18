package com.atenfa.pishgoo.model.data

import java.util.Calendar

data class Data(
    val lastProphecyCheckedTime: Long = Calendar.getInstance().timeInMillis,
    val lastProphecy: String = "",
    val lastMusicState: Boolean = true
)
