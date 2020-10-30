package io.jk.dev.reign.hackernews.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao.NewsDao
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao.RemovedNewsDao
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.*
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.mapper.StringArrayJsonConverter


@Database(
    entities = [
        NewsEntity::class,
        NewsRemovedEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringArrayJsonConverter::class)
abstract class HackerNewsDataBase : RoomDatabase() {

    abstract fun hitsDao(): NewsDao

    abstract fun removedHitsDao(): RemovedNewsDao

    companion object {
        @Volatile
        lateinit var room: HackerNewsDataBase

        fun initializeDatabase(context: Context) {

            if (::room.isInitialized) return

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HackerNewsDataBase::class.java,
                    "hacker_news_database"
                ).build()
                room = instance
            }
        }

    }
}