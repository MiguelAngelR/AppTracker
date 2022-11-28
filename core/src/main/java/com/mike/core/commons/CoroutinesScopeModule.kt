package com.mike.core.commons

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope

@InstallIn(SingletonComponent::class)
@Module
internal object CoroutinesScopesModule {

    @Singleton
    @ApplicationScope
    @Provides
    fun providesCoroutineScope(@IoDispatcher coroutineDispatcher: CoroutineDispatcher):
            CoroutineScope = CoroutineScope(SupervisorJob() + coroutineDispatcher)

}