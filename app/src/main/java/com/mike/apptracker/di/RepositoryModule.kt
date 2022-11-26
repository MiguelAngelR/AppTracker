package com.mike.apptracker.di

import com.mike.apptracker.commons.IoDispatcher
import com.mike.apptracker.data.repositoryimplementation.MovieRepositoryImpl
import com.mike.apptracker.domain.datasourceabstraction.local.LocalMovieDataSource
import com.mike.apptracker.domain.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.apptracker.domain.repositoryabstraction.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
        localMovieDataSource: LocalMovieDataSource,
        remoteMoviesDataSource: RemoteMoviesDataSource,
    ): MovieRepository = MovieRepositoryImpl(coroutineDispatcher = coroutineDispatcher,
        localMovieDataSource = localMovieDataSource,
        remoteMoviesDataSource = remoteMoviesDataSource
    )

}