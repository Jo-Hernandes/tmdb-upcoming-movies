package com.jhernandes.upcomingmovies.models

import com.jhernandes.datamodule.models.MovieGenre
import java.io.Serializable

data class UpcomingMovie(
    val backdropImagePath: String?,
    val original_title: String,
    val posterPath: String?,
    val releaseDate: String,
    val movieResume: String,
    val id: Int,
    val genresIds : List<Int>,
    var namedGenresList: List<MovieGenre> = listOf()
) : Serializable


