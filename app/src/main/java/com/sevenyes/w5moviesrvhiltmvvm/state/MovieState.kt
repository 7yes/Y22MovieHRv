package com.sevenyes.w5moviesrvhiltmvvm.state

import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250Response
import java.lang.Exception

sealed class MovieState{
    object LOADING : MovieState()
    class SUCCESS(val response: Movie250Response) : MovieState()
    class ERROR(val e: Throwable) : MovieState()
}
