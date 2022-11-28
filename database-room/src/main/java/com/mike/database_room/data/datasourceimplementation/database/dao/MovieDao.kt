package com.mike.database_room.data.datasourceimplementation.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.mike.database_room.domain.entity.PopularMovieEntity

@Dao
internal interface MovieDao: BasicDao<PopularMovieEntity> {

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAll()

    @Query("SELECT * FROM popular_movies WHERE id = :id")
    suspend fun findById(id:String) : PopularMovieEntity?

    @Query("SELECT * FROM popular_movies")
    suspend fun findAllPopularMovies() : List<PopularMovieEntity>?

}