package com.mike.core.repositoryabstraction

import com.mike.core.commons.Result
import com.mike.core.entity.model.PopularMovie
import com.mike.core.repositoryabstraction.BasicLocalRepository

interface MovieRepository: BasicLocalRepository<PopularMovie> {

    ///DATABASE METHODS

    suspend fun findAll(): List<PopularMovie>?

    suspend fun findById(id: String): PopularMovie?

    // REMOTE METHODS

    suspend fun fetchPopularMovies(
        language: String,
        page: String,
        apiKey: String,
        scope: String
    ) : Result<List<PopularMovie>>

}