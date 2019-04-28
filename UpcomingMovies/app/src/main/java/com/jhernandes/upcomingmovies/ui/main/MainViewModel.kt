package com.jhernandes.upcomingmovies.ui.main

import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import com.jhernandes.upcomingmovies.paging.UpcomingMoviesPagedFactory
import com.jhernandes.upcomingmovies.models.UpcomingMovie

class MainViewModel(moviesPagedFactory : UpcomingMoviesPagedFactory) : ViewModel() {

    var listLiveData: LiveData<PagedList<UpcomingMovie>>? = null

    init {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(20)
            .setInitialLoadSizeHint(20)
            .setPrefetchDistance(5)
            .build()

        listLiveData = LivePagedListBuilder<Int, UpcomingMovie>(moviesPagedFactory, config).build()
    }


    // fun getErrorMessage () = Transformations.switchMap(moviesPagedFactory, PagedMoviesListAdapterClass::errorMessage)
}
