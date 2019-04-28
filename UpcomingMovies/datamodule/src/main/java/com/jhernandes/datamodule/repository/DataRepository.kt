package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.models.UpcomingListResult
import io.reactivex.Single

interface DataRepository {

    fun getUpcomingMovies(): Single<UpcomingListResult>

    fun getUpcomingMovies(page: Int): Single<UpcomingListResult>
}