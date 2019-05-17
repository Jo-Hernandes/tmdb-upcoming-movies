package com.jhernandes.upcomingmovies.paging

import androidx.paging.DataSource
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class UpcomingMoviesPagedFactory(private val moviesDataSource: MoviesDataSource) :
    DataSource.Factory<Int, UpcomingMovie>() {

    override fun create(): DataSource<Int, UpcomingMovie> {
        return PagedMoviesListDataSource(moviesDataSource)
    }

}