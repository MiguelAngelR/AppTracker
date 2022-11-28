package com.mike.apptracker.model

import android.util.Log
import com.mike.apptracker.contract.MainFragmentContract
import com.mike.core.entity.model.PopularMovie
import com.mike.core.repositoryabstraction.MovieRepository
import javax.inject.Inject
import com.mike.core.commons.Result

class MainFragmentModel @Inject constructor(
    private val repository: MovieRepository
) : MainFragmentContract.MainFragmentModel {

    override suspend fun getPopularMoviesFromRepository(language: String, page: String, apiKey: String, scope: String): Result<List<PopularMovie>> =
        repository.fetchPopularMovies(
            language = language,
            page = page,
            apiKey = apiKey,
            scope = scope
        )


    override suspend fun storePopularMovies(list:List<PopularMovie>): Boolean {
        Log.e("almacenando  data", "Almacenando informacion en la BD")
        repository.insert(list)
        return true
    }

}