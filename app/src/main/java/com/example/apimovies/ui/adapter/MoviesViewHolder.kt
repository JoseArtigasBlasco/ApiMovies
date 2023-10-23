package com.example.apimovies.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apimovies.databinding.ItemMovieBinding
import com.example.apimovies.model.Movie

class MoviesViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(movie: Movie) {
        binding.tvMovieName.text = movie.title
        Glide.with(binding.root.context)
            .load("https://image.tmdb.org/t/p/w185${movie.posterPath}")
            .into(binding.ivMovie)
    }
}