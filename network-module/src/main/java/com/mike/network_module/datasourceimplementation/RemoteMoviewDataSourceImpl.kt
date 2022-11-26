package com.mike.network_module.datasourceimplementation

import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.apptracker.domain.entity.model.PopularMovie
import com.mike.network_module.mapper.asPopularMoviesDomainList
import com.mike.network_module.service.MoviesService

internal class RemoteMoviewDataSourceImpl(private val movieService: MoviesService) :
    RemoteMoviesDataSource {

    override suspend fun fetchPopularMovies(
        authHeader: String,
        page: String,
        language: String,
        scope: String
    ): Result<List<PopularMovie>> =
        safeApiCall {
            movieService.fetchPopularMovies(
                authHeader = authHeader,
                language = language,
                page = page
            ).asPopularMoviesDomainList()
        }


}