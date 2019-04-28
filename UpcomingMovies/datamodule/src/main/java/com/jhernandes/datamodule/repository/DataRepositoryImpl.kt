package com.jhernandes.datamodule.repository

import com.jhernandes.datamodule.BuildConfig
import com.jhernandes.datamodule.restService.RestImpl
import com.jhernandes.datamodule.restService.WebService

class DataRepositoryImpl : DataRepository {

    companion object {
        const val key = BuildConfig.TMDB_KEY
    }

    override fun getUpcomingMovies() = getUpcomingMovies(1)

    override fun getUpcomingMovies(page: Int) = getRestService().getUpcomingMovies(key, page)

    private fun getRestService () : WebService = RestImpl().provideWebService()

}