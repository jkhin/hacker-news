package io.jk.dev.reign.hackernews.features.news.data.repository

import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsRemovedDataStorage
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.NewsEntity
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.NewsCloudStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response.HitsResponse
import io.jk.dev.reign.hackernews.features.news.data.mapper.HitsEntityMapper
import io.jk.dev.reign.hackernews.features.news.data.mapper.HitsMapper
import io.jk.dev.reign.hackernews.features.news.domain.model.Hits
import io.jk.dev.reign.hackernews.features.news.domain.repository.NewsRepository

class NewsRepositoryImpl(
    private val newsCloudStore: NewsCloudStore,
    private val newsDataStore: NewsDataStore,
    private val removedNewsDataStore: NewsRemovedDataStorage,
    private val hitsEntityMapper: HitsEntityMapper,
    private val hitsMapper: HitsMapper
) : NewsRepository {

    override suspend fun getNewsByDate(environment: String): List<Hits> {
//        if (hasInternetConnection()) {
        val response = newsCloudStore.searchNewsByDate(environment)
        val entities = saveResponseAndGetEntities(response.hits)
        return hitsMapper.map(entities)

//        } else {
//
//        }
        // TODO("check if is networking available")
        // TODO("if it's enabled > get response news")
        // TODO("else > get news from local-storage")

        // TODO("map response news to entity")
        // TODO("check if it exists in local storage")
        // TODO("if exists > omit")
        // TODO("else > save")
        // TODO("save it to local storage")
        // TODO("")
    }

    override suspend fun removeNew(objectId: String) {

    }

    private suspend fun saveResponseAndGetEntities(hits: List<HitsResponse>): List<NewsEntity> {
        val entities = hitsEntityMapper.map(hits)
        // TODO("Save entities to local storage")
        return entities
    }

}