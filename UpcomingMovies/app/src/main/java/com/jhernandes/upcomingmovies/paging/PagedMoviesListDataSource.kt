package com.jhernandes.upcomingmovies.paging

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.dataSource.WebAdapter
import com.jhernandes.upcomingmovies.models.UpcomingMovie
import io.reactivex.functions.BiFunction

class PagedMoviesListDataSource(private val moviesDataSource: MoviesDataSource) :
    PageKeyedDataSource<Int, UpcomingMovie>() {

    private val errorMessage: MutableLiveData<String> = MutableLiveData()
    private var genreList: List<MovieGenre> = mutableListOf()

    @SuppressLint("CheckResult")
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UpcomingMovie>) {
        val upcomingMovies = moviesDataSource.getUpcomingMovies()
        val movieGenresList = moviesDataSource.getMovieGenresList()

        upcomingMovies
            .zipWith(movieGenresList,
                BiFunction<MutableList<UpcomingMovie>, List<MovieGenre>, MutableList<UpcomingMovie>>
                { movies: MutableList<UpcomingMovie>, genres: List<MovieGenre> ->
                    genreList = genres
                    for (upcomingMovieItem in movies) {
                        WebAdapter().insertGenresList(upcomingMovieItem, genreList)
                    }
                    movies
                })
            .subscribe(
                { callback.onResult(it, null, 2) },
                { errorMessage.postValue(it.localizedMessage) }
            )
    }

    @SuppressLint("CheckResult")
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {
        moviesDataSource.loadMore(params.key)
            .subscribe(
                {
                    for (upcomingMovieItem in it) {
                        WebAdapter().insertGenresList(upcomingMovieItem, genreList)
                    }
                    callback.onResult(it, params.key + 1)
                },
                {
                    it.printStackTrace()
                    errorMessage.postValue(it.localizedMessage) }
            )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UpcomingMovie>) {}
}