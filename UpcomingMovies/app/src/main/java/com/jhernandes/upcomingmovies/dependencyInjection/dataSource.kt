package com.jhernandes.upcomingmovies.dependencyInjection

import com.jhernandes.datamodule.ServiceModule
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.dataSource.WebSourceDataImpl
import com.jhernandes.upcomingmovies.paging.UpcomingMoviesPagedFactory
import org.koin.dsl.module

val dataSource = module {

    single { ServiceModule().getRestService() }
    single { ServiceModule().getImageService(get()) }

    factory<MoviesDataSource> { WebSourceDataImpl(get()) }
    factory<UpcomingMoviesPagedFactory> { UpcomingMoviesPagedFactory(get()) }
}