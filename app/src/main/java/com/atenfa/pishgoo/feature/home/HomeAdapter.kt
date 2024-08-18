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
import java.util.Calendar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeAdapter(private val context: Context, private val list: List<String>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>(), KoinComponent {

  private lateinit var binding: ItemHomeBinding
  private val prophecy by inject<Prophecy>()
  private val homeViewModel by inject<HomeViewModel>()

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
    binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context))
    return ViewHolder(binding)
  }

  override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {

    val prophecy: String = prophecy.getProphecy(position)
    holder.tvEmoticon.text = list[position]
    holder.tvEmoticon.setOnClickListener {
      CoroutineScope(Dispatchers.Main).launch {
        val time = homeViewModel.getData(context).first().lastProphecyCheckedTime
        val t = time + 5 * 60 * 1000
        if (Calendar.getInstance().timeInMillis >= t) {
          homeViewModel.readProphecy(context, prophecy)
          showDialog(prophecy, it.context)
        }
        else {
          val timeLeft = (t - Calendar.getInstance().timeInMillis) / 1000
          showDialog(context.getString(R.string.try_again) + "\n زمان باقی مانده:  $timeLeft "+ "ثانیه", it.context)
        }
      }
    }
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

  inner class ViewHolder(binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
    val tvEmoticon = binding.tvEmoticon
  }
}
