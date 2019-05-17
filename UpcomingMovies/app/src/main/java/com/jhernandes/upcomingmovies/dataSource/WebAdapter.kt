package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.datamodule.models.Result
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class WebAdapter {

    fun getFromResult(movieResult: Result): UpcomingMovie =
        UpcomingMovie(
            backdropImagePath = movieResult.backdrop_path,
            movieTitle = movieResult.original_title,
            posterPath = movieResult.poster_path,
            releaseDate = movieResult.release_date,
            movieResume = movieResult.overview,
            id = movieResult.id,
            genresIds =  movieResult.genre_ids,
            namedGenresList = null
        )

    fun insertGenresList(movie: UpcomingMovie, genres: List<MovieGenre>): UpcomingMovie {
        movie.namedGenresList = genres.filter { movie.genresIds.contains(it.id) }
        return movie
    }
}