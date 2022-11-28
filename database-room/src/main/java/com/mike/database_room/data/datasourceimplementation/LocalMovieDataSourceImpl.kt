package com.mike.database_room.data.datasourceimplementation

import com.mike.core.datasourceabstraction.local.LocalMovieDataSource
import com.mike.core.entity.model.PopularMovie
import com.mike.database_room.data.datasourceimplementation.database.dao.MovieDao
import com.mike.database_room.domain.entity.asPopularMovie
import com.mike.database_room.domain.entity.asPopularMovieEntity
import com.mike.database_room.domain.entity.asPopularMovieEntityList
import com.mike.database_room.domain.entity.asPopularMovieList

internal class LocalMovieDataSourceImpl(private val movieDao: MovieDao) : LocalMovieDataSource {

    override suspend fun insert(model: PopularMovie): Long = movieDao.insert(model.asPopularMovieEntity())

    override suspend fun insert(models: List<PopularMovie>) = movieDao.insert(models.asPopularMovieEntityList())

    override suspend fun update(model: PopularMovie) = movieDao.update(model.asPopularMovieEntity())

    override suspend fun update(models: List<PopularMovie>) = movieDao.update(models.asPopularMovieEntityList())

    override suspend fun delete(model: PopularMovie) =  movieDao.delete(model.asPopularMovieEntity())

    override suspend fun deleteAll() = movieDao.deleteAll()

    override suspend fun findById(id: String): PopularMovie? = movieDao.findById(id)?.asPopularMovie()

    override suspend fun findAllPopularMovies(): List<PopularMovie>? = movieDao.findAllPopularMovies()?.asPopularMovieList()


}