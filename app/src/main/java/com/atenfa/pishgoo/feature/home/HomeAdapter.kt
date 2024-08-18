package com.atenfa.pishgoo.feature.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.atenfa.pishgoo.databinding.ItemHomeBinding

class HomeAdapter(private val list: List<String>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

  private lateinit var binding: ItemHomeBinding

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
    binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
    holder.tvEmoticon.text = list[position]
    holder.tvEmoticon.setOnClickListener {
      // todo: click event
    }
  }

  override fun getItemCount() = list.size

  inner class ViewHolder(private val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
    val tvEmoticon = binding.tvEmoticon
  }
}
