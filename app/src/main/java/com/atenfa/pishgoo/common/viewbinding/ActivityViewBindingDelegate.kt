package com.atenfa.pishgoo.common.viewbinding

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> AppCompatActivity.viewBinding() =
    ActivityBindingDelegate(T::class.java, this)

class ActivityBindingDelegate<T : ViewBinding>(
    bindClass: Class<T>,
    val activity: AppCompatActivity
) : ReadOnlyProperty<AppCompatActivity, T> {

  private var binding: T? = null
  private val bindMethod = bindClass.getMethod("inflate", LayoutInflater::class.java)

  override fun getValue(thisRef: AppCompatActivity, property: KProperty<*>): T {
    binding?.let {
      return it
    }
    val lifecycle = thisRef.lifecycle
    if (!lifecycle.currentState.isAtLeast(androidx.lifecycle.Lifecycle.State.INITIALIZED)) {
        error("$ERROR_ACCESS_BINDING ${lifecycle.currentState}")
    }
      binding = bindMethod.invoke(null, thisRef.layoutInflater)!!.cast()
      return binding!!
  }

    companion object{
        const val ERROR_ACCESS_BINDING = "Cannot access viewBinding activity lifecycle is "
    }
}

@Suppress("UNCHECKED_CAST")
private fun <T> Any.cast():T = this as T