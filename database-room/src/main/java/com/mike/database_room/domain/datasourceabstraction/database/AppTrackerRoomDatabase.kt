package com.mike.database_room.domain.datasourceabstraction.database

import com.mike.database_room.data.datasourceimplementation.database.dao.MovieDao

internal interface AppTrackerRoomDatabase {

    fun movieDao() : MovieDao

}