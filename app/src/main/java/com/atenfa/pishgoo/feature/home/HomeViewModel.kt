package com.atenfa.pishgoo.feature.home

import android.content.Context
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.atenfa.pishgoo.common.base.BaseViewModel
import com.atenfa.pishgoo.model.data.Data
import com.atenfa.pishgoo.model.repository.DataRepository
import com.atenfa.pishgoo.utils.Constant
import java.util.Calendar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: DataRepository) : BaseViewModel() {

  private val _emoticon: MutableStateFlow<List<String>> by lazy {
    MutableStateFlow(getEmoticon().shuffled())
  }
  val emoticon = _emoticon.asLiveData()

  fun getData(context: Context) = repository.read(context)

  fun readProphecy(context: Context, text: String) {
    val date = Calendar.getInstance().timeInMillis
    viewModelScope.launch {
      val newData =
          getData(context).first().copy(lastProphecy = text, lastProphecyCheckedTime = date)
      repository.write(context, newData)
    }
  }

  fun updateMusicState(context: Context, state: Boolean) {
    val newData = Data(lastMusicState = state)
    viewModelScope.launch { repository.write(context, newData) }
  }

  private fun getEmoticon(): List<String> {
    return Constant.emoticons
  }
}
