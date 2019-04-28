package com.jhernandes.upcomingmovies

import android.app.Application
import com.jhernandes.upcomingmovies.dependencyInjection.application
import com.jhernandes.upcomingmovies.dependencyInjection.dataSource
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class UpcomingMoviesApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            // Android context
            androidContext(this@UpcomingMoviesApplication)
            // modules
            modules(application + dataSource)
        }
    }
}