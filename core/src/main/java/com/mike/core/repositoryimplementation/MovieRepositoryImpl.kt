package com.mike.core.repositoryimplementation

import com.mike.core.commons.Result
import com.mike.core.datasourceabstraction.local.LocalMovieDataSource
import com.mike.core.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.core.entity.model.PopularMovie
import com.mike.core.repositoryabstraction.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val coroutineDispatcher: CoroutineDispatcher,
    private val localMovieDataSource: LocalMovieDataSource,
    private val remoteMoviesDataSource: RemoteMoviesDataSource
): MovieRepository {

    override suspend fun insert(model: PopularMovie): Long = localMovieDataSource.insert(model)

    override suspend fun insert(models: List<PopularMovie>) = localMovieDataSource.insert(models)

    override suspend fun update(model: PopularMovie) = localMovieDataSource.update(model)

    override suspend fun update(models: List<PopularMovie>)  = localMovieDataSource.update(models)

    override suspend fun delete(model: PopularMovie) = localMovieDataSource.delete(model)

    override suspend fun deleteAll() = localMovieDataSource.deleteAll()

    override suspend fun findById(id: String): PopularMovie? = localMovieDataSource.findById(id)

    override suspend fun fetchPopularMovies(
        language: String,
        page: String,
        apiKey: String,
        scope: String
    ): Result<List<PopularMovie>> = withContext(coroutineDispatcher) {
        remoteMoviesDataSource.fetchPopularMovies(
            apiKey = apiKey,
            page = page,
            scope = scope,
            language = language
        )
    }
}