package com.jhernandes.upcomingmovies.dependencyInjection

import com.jhernandes.datamodule.ServiceModule
import com.jhernandes.upcomingmovies.dataSource.DataSource
import com.jhernandes.upcomingmovies.dataSource.WebSourceDataImpl
import org.koin.dsl.module

val dataSource = module {

    single { ServiceModule().getRestService() }
    single { ServiceModule().getImageService(get()) }

    factory<DataSource> { WebSourceDataImpl(get()) }
}