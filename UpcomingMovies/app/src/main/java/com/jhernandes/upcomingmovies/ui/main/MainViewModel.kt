package com.jhernandes.upcomingmovies.ui.main

import android.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import com.jhernandes.upcomingmovies.dataSource.MoviesDataSource
import com.jhernandes.upcomingmovies.paging.UpcomingMoviesPagedFactory
import com.jhernandes.upcomingmovies.models.UpcomingMovie
import com.jhernandes.upcomingmovies.paging.MovieQueryPagedFactory
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MainViewModel(val dataSource : MoviesDataSource) : ViewModel(),
    SearchView.OnQueryTextListener {

    private val textChangeSubject: PublishSubject<String> = PublishSubject.create<String>()
    var listLiveData: LiveData<PagedList<UpcomingMovie>>? = null
    var queryLiveData : LiveData<PagedList<UpcomingMovie>>? = null
    var isQueryLiveData : MutableLiveData<Boolean> = MutableLiveData()

    private val config : PagedList.Config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(20)
        .setInitialLoadSizeHint(20)
        .setPrefetchDistance(5)
        .build()

    init {
        listLiveData = LivePagedListBuilder<Int, UpcomingMovie>(UpcomingMoviesPagedFactory(dataSource), config).build()
        queryChangeObserver().subscribe(consumeString())
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            textChangeSubject.onNext(query)
            isQueryLiveData.postValue(true)
            return true
        }
        textChangeSubject.onNext("")
        isQueryLiveData.postValue(false)
        return false

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        newText?.let {
            textChangeSubject.onNext(newText)
            isQueryLiveData.postValue(true)
            return true
        }
        textChangeSubject.onNext("")
        isQueryLiveData.postValue(false)
        return false
    }

    private fun queryChangeObserver() : Observable<String> = textChangeSubject.debounce(200, TimeUnit.MILLISECONDS).distinctUntilChanged()

    private fun consumeString () : Consumer<String> = Consumer {
        queryLiveData = LivePagedListBuilder<Int, UpcomingMovie>(MovieQueryPagedFactory(dataSource, it), config).build()
    }

}
