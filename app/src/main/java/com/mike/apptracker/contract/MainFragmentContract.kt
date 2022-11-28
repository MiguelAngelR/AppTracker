package com.mike.apptracker.contract

import com.mike.core.entity.model.PopularMovie
import com.mike.core.commons.Result

interface MainFragmentContract {

    interface MainFragmentView{
        fun showPopularMovies(popularMovie: MutableList<PopularMovie>)
        fun showError(message: String)
    }

    interface MainFragmentPresenter{
        fun getPopularMovies()
    }

    interface MainFragmentModel{
        suspend fun storePopularMovies(listPopularMovies: List<PopularMovie>) : Boolean
        suspend fun getPopularMoviesFromRepository(language: String, page: String, auth: String, scope: String): Result<List<PopularMovie>>
    }

}