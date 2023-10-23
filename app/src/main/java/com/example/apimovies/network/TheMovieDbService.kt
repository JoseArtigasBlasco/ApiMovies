package com.example.apimovies.network

import com.example.apimovies.model.MoviewDbResults
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMovieDbService {

    @GET("movie/popular")
    suspend fun listPopularMovies(@Query("api_key") apiKey : String) : MoviewDbResults
}