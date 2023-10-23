package com.example.apimovies


import com.example.apimovies.ObjetMovies.movies
import com.example.apimovies.ui.adapter.MoviesAdapter
import org.junit.Test
import org.junit.Assert.assertEquals

class MoviesAdapterTest {


    @Test
    fun `check the received items in the moviesAdapter`() {

        val peliculas = movies

        val adapter = MoviesAdapter(peliculas) { /* Click listener lambda */ }

        assertEquals(movies.size, adapter.itemCount)
    }
}