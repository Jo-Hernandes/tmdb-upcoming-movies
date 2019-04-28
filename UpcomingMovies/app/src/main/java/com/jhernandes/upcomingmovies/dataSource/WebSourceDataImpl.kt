package com.jhernandes.upcomingmovies.dataSource

import com.jhernandes.datamodule.repository.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WebSourceDataImpl(private val webRepository : DataRepository) : DataSource {

    companion object {
        var pageNumber = 0
    }

    override fun getUpcomingMovies(callback: DataCallback) {
        pageNumber = 0
        loadMovies(0, callback)
    }

    override fun loadMode(callback: DataCallback) {
        loadMovies(pageNumber, callback)
    }

    private fun loadMovies(page : Int, callback: DataCallback) {
        webRepository.getUpcomingMovies(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { response -> response.results }
            .map { result -> WebAdapter().getFromResult(result)  }
            .doOnComplete {
                pageNumber++
                callback.onComplete() }
            .toList()
            .subscribe( { movieList -> callback.onSuccess(movieList, movieList.size < 20)},
                {callback.onError(it.localizedMessage)})
        // todo refactor error localized message 
    }



}