package io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * from news_table")
    fun getNews(): List<NewsEntity>

    @Query("DELETE FROM news_table WHERE objectId = :objectId")
    fun removeNews(objectId: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNews(news: List<NewsEntity>)

}