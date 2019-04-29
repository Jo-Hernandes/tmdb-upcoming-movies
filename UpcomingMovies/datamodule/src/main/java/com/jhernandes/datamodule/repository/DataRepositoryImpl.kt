package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.BuildConfig
import com.jhernandes.datamodule.models.MovieGenre
import com.jhernandes.datamodule.restService.RestImpl
import com.jhernandes.datamodule.restService.WebService
import io.reactivex.Observable

class DataRepositoryImpl : DataRepository {

    companion object {
        const val key = BuildConfig.TMDB_KEY
    }

    override fun getUpcomingMovies() = getUpcomingMovies(1)

    override fun getUpcomingMovies(page: Int) = getRestService().getUpcomingMovies(key, page)

    override fun getMoviesGenreList() = getRestService().getGenresList(key)

    private fun getRestService () : WebService = RestImpl().provideWebService()


}
