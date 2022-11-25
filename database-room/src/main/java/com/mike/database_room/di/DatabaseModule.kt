package com.mike.database_room.di

import android.content.Context
import com.mike.database_room.data.datasourceimplementation.database.AppTrackerRoomDatabaseImpl
import com.mike.database_room.domain.datasourceabstraction.database.AppTrackerRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {


    @Singleton
    @Provides
    fun provideAppTrackerRoomDatabase(@ApplicationContext context: Context) : AppTrackerRoomDatabase =
        AppTrackerRoomDatabaseImpl.getInstance(context)

}