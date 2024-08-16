package com.atenfa.pishgoo.common.base

import android.view.View
import com.google.android.material.snackbar.Snackbar

interface PishgooView {

  fun showSnackBar(view: View, message: String, length: Int = Snackbar.LENGTH_SHORT)
}
