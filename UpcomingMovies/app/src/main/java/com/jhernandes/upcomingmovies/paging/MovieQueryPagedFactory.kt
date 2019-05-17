package com.jhernandes.upcomingmovies.paging

import androidx.paging.DataSource
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class MovieQueryPagedFactory(private val moviesDataSource: MoviesDataSource, private val query : String) :
    DataSource.Factory<Int, UpcomingMovie>() {

    override fun create(): DataSource<Int, UpcomingMovie> {
        return PagedQueryListDataSource(moviesDataSource, query)
    }

}