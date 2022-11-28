package com.mike.core.datasourceabstraction.remote

import com.mike.core.commons.RemoteDataSource
import com.mike.core.commons.Result
import com.mike.core.entity.model.PopularMovie

interface RemoteMoviesDataSource : RemoteDataSource {

    suspend fun fetchPopularMovies(
        authHeader: String,
        page: String,
        language: String,
        scope: String
    ): Result<List<PopularMovie>>

}