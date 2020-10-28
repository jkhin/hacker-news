package io.jk.dev.reign.hackernews.features.news.data.datasource.rest

import io.jk.dev.reign.hackernews.core.network.api.HackerNewsApi

class NewsCloudStore(
    private val hackerNewsApi: HackerNewsApi
) {

    suspend fun searchNewsByDate(environment: String) {
        return hackerNewsApi.getNewsByDate(environment)
    }

}