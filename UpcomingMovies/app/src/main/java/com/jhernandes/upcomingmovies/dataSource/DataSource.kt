package com.jhernandes.upcomingmovies.dataSource

interface DataSource {

    fun getUpcomingMovies(callback : DataCallback)

    fun loadMode(callback : DataCallback)
}