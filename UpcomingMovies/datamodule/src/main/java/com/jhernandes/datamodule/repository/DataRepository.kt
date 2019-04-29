package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.models.GenreListResult
import com.jhernandes.datamodule.models.MovieListResult
import io.reactivex.Observable

interface DataRepository {

    fun getUpcomingMovies(): Observable<MovieListResult>

    fun getUpcomingMovies(page: Int): Observable<MovieListResult>

    fun getMoviesGenreList() : Observable<GenreListResult>

    fun getMovieQuery(query : String) : Observable<MovieListResult>

    fun getMovieQuery(query : String, page : Int) : Observable<MovieListResult>

}