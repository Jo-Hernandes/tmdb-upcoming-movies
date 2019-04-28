package com.jhernandes.upcomingmovies.dependencyInjection

import com.jhernandes.upcomingmovies.ui.main.MainFragment
import com.jhernandes.upcomingmovies.ui.main.MainViewModel
import org.koin.dsl.module

val application = module{

    factory { MainViewModel(get()) }

    factory { MainFragment() }
}