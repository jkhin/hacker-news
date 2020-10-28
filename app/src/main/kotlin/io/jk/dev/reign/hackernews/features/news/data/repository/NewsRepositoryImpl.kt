package io.jk.dev.reign.hackernews.features.news.data.repository

import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.RemovedNewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.NewsCloudStore
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsEntityMapper

class NewsRepositoryImpl(
    private val newsCloudStore: NewsCloudStore,
    private val newsDataStore: NewsDataStore,
    private val removedNewsDataStore: RemovedNewsDataStore,
    private val newsEntityMapper: NewsEntityMapper
) {

    suspend fun getNewsByDate(environment: String) {
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

}