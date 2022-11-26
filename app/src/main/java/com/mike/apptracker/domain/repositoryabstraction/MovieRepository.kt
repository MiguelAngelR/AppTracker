package com.mike.apptracker.domain.repositoryabstraction

import com.mike.apptracker.commons.Result
import com.mike.apptracker.domain.entity.model.PopularMovie

interface MovieRepository: BasicLocalRepository<PopularMovie> {

    ///DATABASE METHODS

    suspend fun findById(id: String): PopularMovie?

    // REMOTE METHODS

    suspend fun fetchPopularMovies(
        authHeader: String,
        page: String,
        scope: String,
        language: String
    ) :Result<List<PopularMovie>>

}