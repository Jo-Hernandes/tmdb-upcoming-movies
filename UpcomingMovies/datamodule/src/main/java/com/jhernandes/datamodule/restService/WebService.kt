package com.jhernandes.datamodule.restService

import com.jhernandes.datamodule.models.GenreListResult
import com.jhernandes.datamodule.models.MovieListResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WebService {

    @Headers("Content-Type: application/json")
    @GET("movie/upcoming")
    fun getUpcomingMovies(@Query("api_key") apiKey : String,
        @Query("page") pageNumber : Int) : Observable<MovieListResult>


    @Headers("Content-Type: application/json")
    @GET("genre/movie/list")
    fun getGenresList(@Query("api_key") apiKey : String) : Observable<GenreListResult>

    @Headers("Content-Type: application/json")
    @GET("search/movie")
    fun queryMovie(@Query("api_key") apiKey : String,
        @Query("query") query: String,
        @Query("page" ) page : Int) : Observable<MovieListResult>

}