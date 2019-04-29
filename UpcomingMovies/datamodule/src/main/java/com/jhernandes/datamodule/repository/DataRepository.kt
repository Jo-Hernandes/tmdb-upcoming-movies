package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.models.GenreListResult
import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.datamodule.models.UpcomingListResult
import io.reactivex.Observable

interface DataRepository {

    fun getUpcomingMovies(): Observable<UpcomingListResult>

    fun getUpcomingMovies(page: Int): Observable<UpcomingListResult>

    fun getMoviesGenreList() : Observable<GenreListResult>
}