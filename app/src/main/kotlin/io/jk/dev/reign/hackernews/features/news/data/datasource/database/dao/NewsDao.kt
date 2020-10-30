package io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao

import androidx.room.*
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsEntity

@Dao
interface NewsDao {

    @Query("SELECT * from news_table WHERE isRemoved = 0")
    fun getNonNewsRemoved(): List<NewsEntity>

    @Query("SELECT * from news_table")
    fun getNewsStored(): List<NewsEntity>

    @Query("SELECT * from news_table WHERE objectId = :objectId")
    fun getNewsByObjectId(objectId: String): NewsEntity

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNews(entity: NewsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: List<NewsEntity>)

}