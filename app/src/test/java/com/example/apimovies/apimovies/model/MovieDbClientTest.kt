package com.example.apimovies.apimovies.model

import com.example.apimovies.core.MovieDbClient
import junit.framework.Assert.assertNotNull
import org.junit.Test

class MovieDbClientTest {



    @Test
    fun `Verify that null is not received`() {
        assertNotNull(MovieDbClient.service)
    }
}