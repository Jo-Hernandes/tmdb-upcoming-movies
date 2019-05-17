package com.jhernandes.upcomingmovies.paging

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class PagedQueryListDataSource(private val moviesDataSource: MoviesDataSource, private val query: String) :
    PageKeyedDataSource<Int, UpcomingMovie>() {


    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UpcomingMovie>) {
        moviesDataSource
            .queryMovie(query)
            .subscribe(
                { callback.onResult(it, null, 2) },
                { it.printStackTrace() }
            )
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {
        moviesDataSource
            .queryMovie(query, params.key)
            .subscribe(
                { callback.onResult(it, params.key + 1) },
                { it.printStackTrace() }
            )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {}
}