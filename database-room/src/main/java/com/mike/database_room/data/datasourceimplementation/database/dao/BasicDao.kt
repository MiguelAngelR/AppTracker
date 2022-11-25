package com.mike.database_room.data.datasourceimplementation.database.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

internal interface BasicDao<E> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: E): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entities: List<E>)

    @Update
    suspend fun update(entity: E)

    @Update
    suspend fun update(entities: List<E>)

    @Delete
    suspend fun delete(entity: E)

}