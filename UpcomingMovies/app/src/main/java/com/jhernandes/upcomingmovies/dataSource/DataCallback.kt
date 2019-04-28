package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.upcomingmovies.models.UpcomingMovie

interface DataCallback {

    fun onComplete()
    fun onSuccess(movies : List<UpcomingMovie>, hasMore : Boolean)
    fun onError(message : String)

}