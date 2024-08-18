package com.atenfa.pishgoo.common.base

import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import org.koin.core.component.KoinComponent

abstract class BaseFragment(@LayoutRes id: Int) :
    Fragment(id), PishgooView, CoroutineScope by CoroutineScope(Dispatchers.Main) {


  override fun showSnackBar(view: View, message: String, length: Int) {
    val bar = Snackbar.make(view, message, length)
    bar.view.layoutDirection = View.LAYOUT_DIRECTION_RTL
    bar.show()
  }

  override fun onDestroy() {
    coroutineContext[Job]?.cancel()
    super.onDestroy()
  }
}
