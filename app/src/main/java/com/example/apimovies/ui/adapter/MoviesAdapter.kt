package com.example.apimovies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.apimovies.databinding.ItemMovieBinding
import com.example.apimovies.model.Movie
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class MoviesAdapter(
    var movies: List<Movie>,
    private val moviewClickerListener: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {

            startRotationAnimation(holder.itemView)

            runBlocking {
                delay(500)
                moviewClickerListener(movies[position])
            }

        }
    }


    private fun startRotationAnimation(view: View) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            start()
        }
    }

}