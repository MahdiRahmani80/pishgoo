package com.atenfa.pishgoo.feature.home

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.getDrawable
import androidx.recyclerview.widget.GridLayoutManager
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.common.base.BaseFragment
import com.atenfa.pishgoo.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import viewBinding

class HomeFragment : BaseFragment(R.layout.fragment_home) {

  private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)
  private val viewModel by inject<HomeViewModel>()
  private val player by inject<MediaPlayer>()

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.recyclerHome.layoutManager = GridLayoutManager(requireContext(), 5)
    viewModel.emoticon.observe(viewLifecycleOwner) {
      binding.recyclerHome.adapter = HomeAdapter(requireContext(), it)
    }

    binding.fabSound.setOnClickListener {
      val bool = stopPauseHandling()
      viewModel.updateMusicState(requireContext(), bool)
    }

    launch {
      viewModel.getData(requireContext()).collect {
        val state = it.lastMusicState
        soundFabViewChane(!state)
      }
    }
  }

  private fun soundFabViewChane(isPlaying: Boolean) {
    if (isPlaying) {
      binding.fabSound.text = getString(R.string.unmute)
      binding.fabSound.icon = getDrawable(requireContext(), R.drawable.audio)
    } else {
      binding.fabSound.text = getString(R.string.mute)
      binding.fabSound.icon = getDrawable(requireContext(), R.drawable.mute)
    }
  }

  private fun stopPauseHandling(): Boolean {
    if (player.isPlaying) {
      player.pause()
      return player.isPlaying
    } else {
      player.start()
      return player.isPlaying
    }
  }
}
