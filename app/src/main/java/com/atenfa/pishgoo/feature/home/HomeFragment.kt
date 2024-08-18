package com.atenfa.pishgoo.feature.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.common.base.BaseFragment
import com.atenfa.pishgoo.databinding.FragmentHomeBinding
import viewBinding

class HomeFragment : BaseFragment(R.layout.fragment_home) {

  private val binding: FragmentHomeBinding by viewBinding(FragmentHomeBinding::bind)

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.recyclerHome.layoutManager = GridLayoutManager(requireContext(), 5)
    binding.recyclerHome.adapter = HomeAdapter(listOf("😜","🙁","😘","🤣","🥰","😇","😁","🙂","😉",))
  }
}
