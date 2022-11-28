package com.mike.apptracker.di

import com.mike.core.commons.IoDispatcher
import com.mike.core.datasourceabstraction.local.LocalMovieDataSource
import com.mike.core.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.core.repositoryabstraction.MovieRepository
import com.mike.core.repositoryimplementation.MovieRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryModule {

    @Singleton
    @Provides
    fun provideMoviesRepository(
        @IoDispatcher coroutineDispatcher: CoroutineDispatcher,
        localMovieDataSource: LocalMovieDataSource,
        remoteMoviesDataSource: RemoteMoviesDataSource,
    ): MovieRepository = MovieRepositoryImpl(
        coroutineDispatcher = coroutineDispatcher,
        localMovieDataSource = localMovieDataSource,
        remoteMoviesDataSource = remoteMoviesDataSource
    )

}