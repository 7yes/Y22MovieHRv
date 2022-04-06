package com.sevenyes.w5moviesrvhiltmvvm.movieapi

import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250Response
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MovieAPI {

    @GET(TOP250_PATH)
    suspend fun getMovies(@Path("MYKEY") myKey : String = MYKEY): Response<Movie250Response>

   @GET(POPULAR_PATH)
   suspend fun getMovies2(@Path("MYKEY") path: String = MYKEY) : Response<Movie250Response>

    companion object{
        const val BASE_PATH = "https://imdb-api.com/en/API/"
        private const val TOP250_PATH = "Top250TVs/{MYKEY}"
        private  const val POPULAR_PATH = "MostPopularMovies/{MYKEY}"
        private const val MYKEY = "k_27aipn0z"
    }

}
