package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.upcomingmovies.models.UpcomingMovie
import io.reactivex.Single

interface MoviesDataSource {

    fun getUpcomingMovies() : Single<MutableList<UpcomingMovie>>

    fun loadMore(position : Int) : Single<MutableList<UpcomingMovie>>

    fun getMovieGenresList() : Single<List<MovieGenre>>
}