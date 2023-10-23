package com.example.apimovies.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.apimovies.ui.adapter.MoviesAdapter
import com.example.apimovies.R
import com.example.apimovies.databinding.ActivityMainBinding

import com.example.apimovies.model.Movie
import com.example.apimovies.core.MovieDbClient
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private val moviesAdapter = MoviesAdapter(emptyList()) { it -> navegateTo(it) }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = moviesAdapter

        //Shimmer
        Handler(Looper.getMainLooper()).postDelayed({
            shimmer()
            searchMovies()
        }, 1000)


    }

    fun shimmer(){
        binding.shimmerView.stopShimmer()
        binding.shimmerView.visibility = View.GONE
    }
    private fun navegateTo(movie: Movie) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
        startActivity(intent)
    }

    private fun searchMovies() {



        lifecycleScope.launch() {
            val apikey = getString(R.string.api_key)
            val popularMovies = MovieDbClient.service.listPopularMovies(apikey)

            moviesAdapter.movies = popularMovies.results
            moviesAdapter.notifyDataSetChanged()

        }
    }
}



