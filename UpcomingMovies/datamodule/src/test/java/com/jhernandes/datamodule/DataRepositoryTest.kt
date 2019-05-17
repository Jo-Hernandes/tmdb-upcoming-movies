package com.jhernandes.datamodule

import com.jhernandes.datamodule.repository.DataRepositoryImpl
import org.junit.Test
import retrofit2.adapter.rxjava2.HttpException

class DataRepositoryTest {

    @Test
    fun checkResponse() {
        DataRepositoryImpl().getUpcomingMovies()
            .test()
            .assertNoTimeout()
            .assertValue { response -> response.page == 1 }
    }

    @Test
    fun checkResponseForPages() {
        val requestedPage = 5
        DataRepositoryImpl().getUpcomingMovies(requestedPage)
            .test()
            .assertNoTimeout()
            .assertValue { response -> response.page == requestedPage }

    }

    @Test
    fun checkNegativeEntryError() {
        val negativeEntry = -1
        DataRepositoryImpl().getUpcomingMovies(negativeEntry)
            .test()
            .assertNoTimeout()
            .assertError {
                it is (HttpException)
            }
    }

    @Test
    fun checkZeroEntryError() {
        val negativeEntry = 0
        DataRepositoryImpl().getUpcomingMovies(negativeEntry)
            .test()
            .assertNoTimeout()
            .assertError {
                it is (HttpException)
            }
    }

    @Test
    fun checkGenreList() {
        DataRepositoryImpl().getMoviesGenreList()
            .test()
            .assertNoTimeout()
            .assertValue { !it.genres.isEmpty() }
    }

}
