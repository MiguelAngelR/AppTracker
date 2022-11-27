package com.mike.apptracker.contract

import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.entity.model.PopularMovie

interface MainFragmentContract {

    interface MainFragmentView{
        fun showPopularMovies(popularMovie: MutableList<PopularMovie>)
        fun showErro(message: String)
    }

    interface MainFragmentPresenter{
        suspend fun getPopularMovies()
    }

    interface MainFragmentModel{
        suspend fun getPopularMoviesFromRepository(language: String, page: String, auth: String, scope: String): Result<List<PopularMovie>>
    }

}