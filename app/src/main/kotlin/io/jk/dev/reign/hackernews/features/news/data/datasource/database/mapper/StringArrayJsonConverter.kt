package io.jk.dev.reign.hackernews.features.news.data.datasource.database.mapper

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type

class StringArrayJsonConverter {

    var moshi: Moshi = Moshi.Builder().build()
    val type: Type = Types.newParameterizedType(List::class.java, String::class.java)
    val adapter = moshi.adapter<List<String>>(type)

    @TypeConverter
    fun jsonToStringList(json: String?): List<String> {
        return if (json == null) emptyList() else adapter.fromJson(json) ?: emptyList()
    }

    @TypeConverter
    fun stringListToSJson(list: List<String>): String {
        return adapter.toJson(list)
    }
}