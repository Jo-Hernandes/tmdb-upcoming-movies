package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.upcomingmovies.models.UpcomingMovie
import io.reactivex.Observable
import io.reactivex.Single

interface MoviesDataSource {

    fun getUpcomingMovies() : Single<MutableList<UpcomingMovie>>

    fun loadMode(position : Int) : Single<MutableList<UpcomingMovie>>
}