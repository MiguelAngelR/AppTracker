package com.mike.network_module.di

import com.mike.core.datasourceabstraction.remote.RemoteMoviesDataSource
import com.mike.network_module.datasourceimplementation.RemoteMoviewDataSourceImpl
import com.mike.network_module.service.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitDatasourceModule {

    @Singleton
    @Provides
    fun provideRemoteMovieDataSource(moviesService: MoviesService): RemoteMoviesDataSource =
        RemoteMoviewDataSourceImpl(movieService = moviesService)

}