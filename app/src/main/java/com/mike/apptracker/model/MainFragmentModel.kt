package com.mike.apptracker.model

import com.mike.apptracker.contract.MainFragmentContract
import com.mike.apptracker.domain.entity.model.PopularMovie
import com.mike.apptracker.domain.repositoryabstraction.MovieRepository
import com.mike.apptracker.commons.Result
import javax.inject.Inject

class MainFragmentModel @Inject constructor(
    private val repository: MovieRepository
) : MainFragmentContract.MainFragmentModel {

    override suspend fun getPopularMoviesFromRepository(language: String, page: String, auth: String, scope: String): Result<List<PopularMovie>> =
        repository.fetchPopularMovies(
            language = language,
            page = page,
            authHeader = auth,
            scope = scope
        )

}