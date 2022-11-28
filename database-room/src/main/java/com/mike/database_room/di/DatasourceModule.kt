package com.mike.database_room.di

import com.mike.core.datasourceabstraction.local.LocalMovieDataSource
import com.mike.database_room.data.datasourceimplementation.LocalMovieDataSourceImpl
import com.mike.database_room.data.datasourceimplementation.database.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatasourceModule {

    @Singleton
    @Provides
    fun provideLocalMovieDataSource(movieDao: MovieDao): LocalMovieDataSource =
        LocalMovieDataSourceImpl(movieDao = movieDao)

}