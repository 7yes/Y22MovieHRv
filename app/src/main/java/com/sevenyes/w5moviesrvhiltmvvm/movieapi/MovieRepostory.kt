package com.sevenyes.w5moviesrvhiltmvvm.movieapi

import android.util.Log
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250Response
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface IMovieRepository {
    suspend fun getMovies250(): Response<Movie250Response>
    suspend fun getMoviesPopular(): Response<Movie250Response>
}

class MovieRepository(private val movieAPI: MovieAPI) : IMovieRepository {
    override suspend fun getMovies250(): Response<Movie250Response> {
        return movieAPI.getMovies250()
    }

    override suspend fun getMoviesPopular(): Response<Movie250Response> {
        return movieAPI.getMoviesPopular()
    }

}
