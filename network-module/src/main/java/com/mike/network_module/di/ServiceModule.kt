package com.mike.network_module.di

import com.mike.network_module.service.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

    @Singleton
    @Provides
    fun provideMoviesService(@CoreRetrofit retrofit: Retrofit): MoviesService =
        retrofit.create(MoviesService::class.java)

}