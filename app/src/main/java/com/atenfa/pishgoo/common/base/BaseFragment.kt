package com.atenfa.pishgoo.common.base

import android.util.LayoutDirection
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseFragment : Fragment(), PishgooView {

  override fun showSnackBar(view: View, message: String, length: Int) {
    val bar = Snackbar.make(view, message, length)
    bar.view.layoutDirection = View.LAYOUT_DIRECTION_RTL
    bar.show()
  }


}
