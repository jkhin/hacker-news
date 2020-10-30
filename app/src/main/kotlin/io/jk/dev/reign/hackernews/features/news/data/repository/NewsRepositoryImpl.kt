package io.jk.dev.reign.hackernews.features.news.data.repository

import io.jk.dev.reign.hackernews.core.utils.NetworkUtils.hasInternetConnection
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsEntity
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.NewsCloudStore
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsEntityMapper
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsMapper
import io.jk.dev.reign.hackernews.features.news.domain.model.News
import io.jk.dev.reign.hackernews.features.news.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsCloudStore: NewsCloudStore,
    private val newsDataStore: NewsDataStore,
    private val newsEntityMapper: NewsEntityMapper,
    private val newsMapper: NewsMapper
) : NewsRepository {

    override suspend fun getNewsByDate(environment: String): List<News> {
        return if (hasInternetConnection()) {
            val response = newsCloudStore.searchNewsByDate(environment)
            val news = newsEntityMapper.map(response.hits)
            val newsStored = newsDataStore.getNewsStored()
            val nonNewsStored = mutableListOf<NewsEntity>()

            news.forEach { entity ->
                if (newsStored.firstOrNull { it.objectId == entity.objectId } == null) {
                    nonNewsStored.add(entity)
                }
            }
            newsDataStore.saveNews(nonNewsStored)

            val entities = newsDataStore.getNonNewsRemoved()

            newsMapper.map(entities)
        } else {
            val entities = newsDataStore.getNonNewsRemoved()
            newsMapper.map(entities)
        }
    }

    override suspend fun removeNew(objectId: String) {
        val news = newsDataStore.getNewsByObjectId(objectId)
        news.isRemoved = 1
        newsDataStore.updateRemovedNews(news)
    }


}