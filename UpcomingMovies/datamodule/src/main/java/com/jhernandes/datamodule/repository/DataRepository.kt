package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.models.UpcomingListResult
import io.reactivex.Observable
import io.reactivex.Single

interface DataRepository {

    fun getUpcomingMovies(): Observable<UpcomingListResult>

    fun getUpcomingMovies(page: Int): Observable<UpcomingListResult>
}