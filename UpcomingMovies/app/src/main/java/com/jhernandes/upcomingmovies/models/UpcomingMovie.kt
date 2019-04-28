package com.jhernandes.upcomingmovies.models

data class UpcomingMovie(
    val backdropImagePath: String,
    val original_title: String,
    val posterPath: String,
    val releaseDate: String,
    val movieResume: String,
    val id: Int
)