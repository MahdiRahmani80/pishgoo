package com.atenfa.pishgoo.common.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.atenfa.pishgoo.common.viewbinding.viewBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseActivity:
    AppCompatActivity(), PishgooView, CoroutineScope by CoroutineScope(Dispatchers.Main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun showSnackBar(view: View, message: String, length: Int) {
    val bar = Snackbar.make(view, message, length)
    bar.view.layoutDirection = View.LAYOUT_DIRECTION_RTL
    bar.show()
  }
}
