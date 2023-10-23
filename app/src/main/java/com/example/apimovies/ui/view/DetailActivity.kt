package com.example.apimovies.ui.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.bumptech.glide.Glide
import com.example.apimovies.databinding.ActivityDetailBinding
import com.example.apimovies.model.Movie

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "DetailActivity:movie"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityDetailBinding
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>(EXTRA_MOVIE)
        if (movie != null) {
            binding.edTitle.text = movie.title
            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w780${movie.backdropPath}")
                .into(binding.backdrop)
            binding.summary.text = movie.overview

            bindDetailInfo(binding.detailInfo, movie)

        }

    }

    @SuppressLint("SetTextI18n")
    private fun bindDetailInfo(detailInfo: TextView, movie: Movie) {
        detailInfo.text = buildSpannedString {

            bold { append("Original lenguaje: ") }
            appendLine(movie.originalLanguage)

            bold { append("Original title: ") }
            appendLine(movie.originalTitle)

            bold { append("Release date: ") }
            appendLine(movie.releaseDate)

            bold { append("Popularity: ") }
            appendLine(movie.popularity.toString())

            bold { append("Vote Average: ") }
            appendLine(movie.voteAverage.toString())
        }
    }
}