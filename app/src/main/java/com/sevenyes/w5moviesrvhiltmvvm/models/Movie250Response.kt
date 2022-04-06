package com.sevenyes.w5moviesrvhiltmvvm.models


import com.google.gson.annotations.SerializedName
import com.sevenyes.w5moviesrvhiltmvvm.models.Movie250

data class Movie250Response(
    @SerializedName("errorMessage")
    val errorMessage: String,
    @SerializedName("items")
    val items: List<Movie250>
)