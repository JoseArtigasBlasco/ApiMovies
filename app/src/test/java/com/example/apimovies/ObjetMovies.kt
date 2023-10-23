package com.example.apimovies

import com.example.apimovies.model.Movie

object ObjetMovies {

    val movies = listOf(
        Movie(
            adult = false,
            backdropPath = "sample_backdrop_path",
            genreIds = emptyList(),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Sample Movie",
            overview = "This is a sample movie overview",
            popularity = 7.8,
            posterPath = "sample_poster_path",
            releaseDate = "2023-10-20",
            title = "Sample Movie",
            video = false,
            voteAverage = 8.0,
            voteCount = 100),


        Movie(
            adult = false,
            backdropPath = "sample_backdrop_path",
            genreIds = emptyList(),
            id = 124,
            originalLanguage = "es",
            originalTitle = "Sample Movie",
            overview = "This is a sample movie overview",
            popularity = 7.5,
            posterPath = "sample_poster_path",
            releaseDate = "2022-10-20",
            title = "Sample Movie",
            video = false,
            voteAverage = 7.0,
            voteCount = 90)

    )

}