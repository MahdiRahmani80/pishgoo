package com.atenfa.pishgoo.feature.main

import android.os.Bundle
import com.atenfa.pishgoo.common.base.BaseActivity
import com.atenfa.pishgoo.common.viewbinding.viewBinding
import com.atenfa.pishgoo.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

  private val binding: ActivityMainBinding by viewBinding()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(binding.root)
  }
}
