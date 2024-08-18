package com.atenfa.pishgoo.feature.home

import androidx.lifecycle.asLiveData
import com.atenfa.pishgoo.common.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class HomeViewModel : BaseViewModel() {

  private val _emoticon: MutableStateFlow<List<String>> by lazy {
    MutableStateFlow(getEmoticon().shuffled())
  }

    val emoticon = _emoticon.asLiveData()

  private fun getEmoticon(): List<String> {
    return listOf(
        "😜",
        "🙁",
        "😘",
        "🤣",
        "🥰",
        "😇",
        "😁",
        "🙂",
        "😉",
        "🤯",
        "🤩",
        "😋",
        "🤑",
        "😷",
        "😨",
        "🥵",
        "😵",
        "🤠",
        "🤗",
        "🧐",
        "🤏",
        "🤙",
        "👻",
        "📕",
    )
  }
}
