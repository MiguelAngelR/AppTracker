package com.mike.network_module.datasourceimplementation

import com.mike.core.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.core.entity.model.PopularMovie
import com.mike.network_module.mapper.asPopularMoviesDomainList
import com.mike.network_module.service.MoviesService
import com.mike.core.commons.Result


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
                apiKey = authHeader,
                language = language,
                page = page
            ).asPopularMoviesDomainList()
        }


}