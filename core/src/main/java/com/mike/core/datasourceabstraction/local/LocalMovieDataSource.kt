package com.mike.core.datasourceabstraction.local

import com.mike.core.entity.model.PopularMovie

interface LocalMovieDataSource {

    suspend fun insert(model: PopularMovie): Long

    suspend fun insert(models: List<PopularMovie>)

    suspend fun update(model: PopularMovie)

    suspend fun update(models: List<PopularMovie>)

    suspend fun delete(model: PopularMovie)

    suspend fun deleteAll()

    suspend fun findById(id: String): PopularMovie?

    suspend fun findAllPopularMovies(): List<PopularMovie>?

}