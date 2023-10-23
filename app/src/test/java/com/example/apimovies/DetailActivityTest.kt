package com.example.apimovies

import com.example.apimovies.ui.view.DetailActivity
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailActivityTest{


    @MockK
    lateinit var activity: DetailActivity


    @Before
    fun setUp(){
        MockKAnnotations.init(this, relaxUnitFun = true)
    }


    @Test
    fun `Comprobar que la activity no es nula`() {

        assertNotNull(activity)}


    @Test
    fun `Comprobar que llegan los datos`() {

        val peliculas = DetailActivity.Companion.EXTRA_MOVIE

        assertNotNull(peliculas)}




}


