package com.atenfa.pishgoo.common.base

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

abstract class BaseActivity :
    AppCompatActivity(), PishgooView, CoroutineScope by CoroutineScope(Dispatchers.Main) {

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
