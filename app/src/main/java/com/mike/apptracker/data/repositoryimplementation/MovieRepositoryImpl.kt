package com.mike.apptracker.data.repositoryimplementation

import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.datasourceabstraction.local.LocalMovieDataSource
import com.mike.apptracker.domain.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.apptracker.domain.entity.model.PopularMovie
import com.mike.apptracker.domain.repositoryabstraction.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

internal class MovieRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteMoviesDataSource: RemoteMoviesDataSource
): MovieRepository{

    override suspend fun insert(model: PopularMovie): Long = localMovieDataSource.insert(model)

    override suspend fun insert(models: List<PopularMovie>) = localMovieDataSource.insert(models)

    override suspend fun update(model: PopularMovie) = localMovieDataSource.update(model)

    override suspend fun update(models: List<PopularMovie>)  = localMovieDataSource.update(models)

    override suspend fun delete(model: PopularMovie) = localMovieDataSource.delete(model)

    override suspend fun deleteAll() = localMovieDataSource.deleteAll()

    override suspend fun findById(id: String): PopularMovie? = localMovieDataSource.findById(id)

    override suspend fun fetchPopularMovies(
        authHeader: String,
        page: String,
        scope: String,
        language: String
    ): Result<List<PopularMovie>> = withContext(coroutineDispatcher) {
        remoteMoviesDataSource.fetchPopularMovies(
            authHeader = authHeader,
            page = page,
            scope = scope,
            language = language
        )
    }
}