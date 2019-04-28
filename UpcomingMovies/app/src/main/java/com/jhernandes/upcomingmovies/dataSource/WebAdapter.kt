package com.jhernandes.upcomingmovies.dataSource

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
            movieResult.id
        )
}