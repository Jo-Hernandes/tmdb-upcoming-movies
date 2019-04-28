package com.jhernandes.upcomingmovies.models

data class UpcomingMovie(
    val backdrop_path: String,
    val original_title: String,
    val poster_path: String,
    val release_date: String,
    val overview: String
)