package com.mike.database_room.di

import com.mike.database_room.data.datasourceimplementation.database.AppTrackerRoomDatabaseImpl
import com.mike.database_room.data.datasourceimplementation.database.dao.MovieDao
import com.mike.database_room.domain.datasourceabstraction.database.AppTrackerRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    fun providePopularMovieDao(roomDatabase: AppTrackerRoomDatabase): MovieDao =
        roomDatabase.movieDao()

}