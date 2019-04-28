package com.jhernandes.datamodule.restService

import com.jhernandes.datamodule.models.UpcomingListResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WebService {

    @Headers("Content-Type: application/json")
    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey : String,
        @Query("page") pageNumber : Int) : Single<UpcomingListResult>

}