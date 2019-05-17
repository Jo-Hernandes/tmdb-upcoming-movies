package com.jhernandes.datamodule.models

data class GenreListResult(
    val genres: List<MovieGenre>
)

data class MovieGenre(
    val id: Int,
    val name: String
)