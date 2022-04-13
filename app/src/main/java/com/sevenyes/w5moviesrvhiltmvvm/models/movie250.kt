package com.sevenyes.w5moviesrvhiltmvvm.models


import com.google.gson.annotations.SerializedName

data class Movie250(
    @SerializedName("crew")
    val crew: String,
    @SerializedName("fullTitle")
    val fullTitle: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("imDbRating")
    val imDbRating: String,
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("rank")
    val rank: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: String,
    @SerializedName("rankUpDown")
    val rankUpDown: String,
    var iLikeIt: Boolean = false
)