package com.mike.apptracker.domain.datasourceabstraction.remote

import com.mike.apptracker.commons.RemoteDataSource
import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.entity.model.PopularMovie

interface RemoteMoviesDataSource : RemoteDataSource {

    suspend fun fetchPopularMovies(
        authHeader: String,
        page: String,
        language: String,
        scope: String
    ): Result<List<PopularMovie>>

}