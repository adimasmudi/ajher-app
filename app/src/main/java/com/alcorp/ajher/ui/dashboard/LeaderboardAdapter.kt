package com.alcorp.ajher.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alcorp.ajher.databinding.ItemLeaderboardBinding

class LeaderboardAdapter(var list: List<Leaderboard>) : RecyclerView.Adapter<LeaderboardAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemLeaderboardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLeaderboardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.tvUsername.text = this.username
                binding.tvScore.text = this.score.toString()
            }
        }
    }

    override fun getItemCount(): Int = list.size
}