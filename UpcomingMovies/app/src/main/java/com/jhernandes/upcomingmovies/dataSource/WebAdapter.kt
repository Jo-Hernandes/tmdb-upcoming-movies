package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.datamodule.models.Result
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class WebAdapter {

    fun getFromResult(movieResult: Result): UpcomingMovie =
        UpcomingMovie(
            movieResult.backdrop_path,
            movieResult.original_title,
            movieResult.poster_path,
            movieResult.release_date,
            movieResult.overview,
            movieResult.id,
            movieResult.genre_ids
        )

    fun insertGenresList(movie: UpcomingMovie, genres: List<MovieGenre>): UpcomingMovie {
        movie.namedGenresList = genres.filter { movie.genresIds.contains(it.id) }
        return movie
    }
}