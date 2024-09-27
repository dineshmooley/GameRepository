package com.example.assignment10.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment10.databinding.GameItemBinding
import com.example.assignment10.domain.Game

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    class MainViewHolder(val binding: GameItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameValue: Game) {
            binding.game = gameValue
            binding.executePendingBindings()
        }
    }

    var games: List<Game> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            GameItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val gameValue = games[position]
        holder.bind(gameValue)
    }
}


