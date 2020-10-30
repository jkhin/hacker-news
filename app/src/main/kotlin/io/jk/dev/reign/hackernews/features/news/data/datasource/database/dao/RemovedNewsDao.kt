package io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsRemovedEntity

@Dao
interface RemovedNewsDao {

    @Query("SELECT * FROM news_removed_table WHERE objectId IN (:news)")
    fun getRemovedNews(news: List<Int>): List<NewsRemovedEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRemovedHit(hit: NewsRemovedEntity)

}