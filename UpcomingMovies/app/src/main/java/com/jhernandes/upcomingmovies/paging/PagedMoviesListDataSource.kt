package com.jhernandes.upcomingmovies.paging

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class PagedMoviesListDataSource(private val moviesDataSource: MoviesDataSource) : PageKeyedDataSource<Int, UpcomingMovie>() {


    val errorMessage : MutableLiveData<String> = MutableLiveData()


    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UpcomingMovie>) {
        moviesDataSource.getUpcomingMovies()
            .subscribe(
                { callback.onResult(it, null, 2) },
                { errorMessage.postValue(it.localizedMessage)}
            )
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {
        moviesDataSource.loadMode(params.key)
            .subscribe(
                { callback.onResult(it, params.key + 1)},
                { errorMessage.postValue(it.localizedMessage)}
            )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {}


}