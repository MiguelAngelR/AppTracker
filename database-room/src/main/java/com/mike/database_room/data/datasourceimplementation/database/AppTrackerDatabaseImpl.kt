package com.mike.database_room.data.datasourceimplementation.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mike.database_room.data.datasourceimplementation.database.AppTrackerRoomDatabaseImpl.Companion.DB_VERSION
import com.mike.database_room.domain.datasourceabstraction.database.AppTrackerRoomDatabase

@Database(
    entities = [

    ],
    version = DB_VERSION,
)
internal abstract class AppTrackerRoomDatabaseImpl: RoomDatabase(), AppTrackerRoomDatabase {

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "apptracker.db"

        @Volatile
        private var instance: AppTrackerRoomDatabaseImpl? = null

        internal fun getInstance(context: Context): AppTrackerRoomDatabaseImpl =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(context: Context): AppTrackerRoomDatabaseImpl =
            Room.databaseBuilder(context, AppTrackerRoomDatabaseImpl::class.java, DB_NAME)
                .build()
    }


}