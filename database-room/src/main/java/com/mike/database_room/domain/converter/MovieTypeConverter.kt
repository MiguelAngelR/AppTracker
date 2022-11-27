package com.mike.database_room.domain.converter

import androidx.room.TypeConverter
import com.google.gson.Gson

internal class MovieTypeConverter {

    @TypeConverter
    fun fromSListToString(intList: List<Int>): String = intList.toString()

    @TypeConverter
    fun fromListIdToString(stringList: String): List<Int> {
        val result = ArrayList<Int>()
        val split =stringList.replace("[","").replace("]","").replace(" ","").split(",")
        for (n in split) {
            try {
                result.add(n.toInt())
            } catch (e: Exception) {

            }
        }
        return result
    }

}