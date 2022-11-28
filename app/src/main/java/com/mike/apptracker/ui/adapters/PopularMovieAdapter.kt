package com.mike.apptracker.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mike.apptracker.R
import com.mike.apptracker.databinding.PopularMovieItemBinding
import com.mike.core.entity.model.PopularMovie

class PopularMovieAdapter() : ListAdapter<PopularMovie, PopularMovieAdapter.ViewHolder>(PopularMovieDiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: PopularMovieItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: PopularMovie) {
            binding.ivMovie.setImageResource(R.drawable.app_icon)
            binding.tvMovieTitle.setText(item.title)

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PopularMovieItemBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }
    }
}


class PopularMovieDiffCallback : DiffUtil.ItemCallback<PopularMovie>() {

    override fun areItemsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
        return oldItem == newItem
    }


}
