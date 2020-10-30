package io.jk.dev.reign.hackernews.features.news.data.datasource.database

import io.jk.dev.reign.hackernews.core.db.HackerNewsDataBase.Companion.room
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.dao.NewsDao
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsEntity

class NewsDataStore {

    private val dao: NewsDao by lazy {
        requireNotNull(room.newsDao())
    }

    fun getNonNewsRemoved(): List<NewsEntity> {
        return dao.getNonNewsRemoved()
    }

    fun getNewsStored(): List<NewsEntity> {
        return dao.getNewsStored()
    }

    fun getNewsByObjectId(objectId: String): NewsEntity {
        return dao.getNewsByObjectId(objectId)
    }

    fun updateRemovedNews(entity: NewsEntity) {
        dao.updateNews(entity)
    }

    fun saveNews(news: List<NewsEntity>) {
        dao.saveNews(news)
    }

}