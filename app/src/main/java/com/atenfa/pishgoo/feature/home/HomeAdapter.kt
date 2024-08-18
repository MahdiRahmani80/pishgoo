package com.atenfa.pishgoo.feature.home

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atenfa.pishgoo.R
import com.atenfa.pishgoo.databinding.DialogShowProphecyBinding
import com.atenfa.pishgoo.databinding.ItemHomeBinding
import com.atenfa.pishgoo.utils.Prophecy
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.java.KoinJavaComponent

class HomeAdapter(private val list: List<String>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(),KoinComponent {

  private lateinit var binding: ItemHomeBinding
  private val prophecy by inject<Prophecy>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
    binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
    holder.tvEmoticon.text = list[position]
    holder.tvEmoticon.setOnClickListener { showDialog(prophecy.getProphecy(position), it.context) }
  }

  override fun getItemCount() = list.size

  private fun showDialog(text: String, ctx: Context) {
    val d = DialogShowProphecyBinding.inflate(LayoutInflater.from(ctx))
    d.txt.text = text
    AlertDialog.Builder(ctx)
        .setView(d.root)
        .setPositiveButton(ctx.getString(R.string.back)) { _, _ -> }
        .show()
  }

  inner class ViewHolder(private val binding: ItemHomeBinding) :
      RecyclerView.ViewHolder(binding.root) {
    val tvEmoticon = binding.tvEmoticon
  }
}
