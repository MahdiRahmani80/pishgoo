package com.atenfa.pishgoo.common.viewbinding

import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingDelegate(T::class.java, this)

class FragmentViewBindingDelegate<T : ViewBinding>(bindClass: Class<T>, fragment: Fragment) :
    ReadOnlyProperty<Fragment,T> {

  private val nullifyBindingHandler by
      lazy(LazyThreadSafetyMode.NONE) { Handler(Looper.getMainLooper()) }
  private var binding: T? = null

  private val bindMethod = bindClass.getMethod("bind", View::class.java)

  init {
    fragment.viewLifecycleOwnerLiveData.observe(fragment) { owner ->
        owner.lifecycle.addObserver(
            object : DefaultLifecycleObserver {
                override fun onDestroy(owner: LifecycleOwner) {
                    nullifyBindingHandler.post { binding = null }
                    super.onDestroy(owner)
                }
            }
        )
    }
  }

  override fun getValue(thisRef: Fragment, property: KProperty<*>): T {

      if (binding!=null && binding?.root !== thisRef.view) {
        binding = null
      }

      binding?.let {
          return it
      }

      val lifecycle = thisRef.viewLifecycleOwner.lifecycle
      if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
          error("Cannot access viewBinding lifecycle is ${lifecycle.currentState}")
      }

      binding = bindMethod.invoke(null, thisRef.requireView())!!.cast()
      return binding!!
  }
}

@Suppress("UNCHECKED_CAST")
private fun <T> Any.cast(): T = this as T