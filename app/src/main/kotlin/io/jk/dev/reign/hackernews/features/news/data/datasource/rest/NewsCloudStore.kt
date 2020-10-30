package io.jk.dev.reign.hackernews.features.news.data.datasource.rest

import io.jk.dev.reign.hackernews.core.network.api.HackerNewsApi
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response.NewsResponse

class NewsCloudStore(
    private val hackerNewsApi: HackerNewsApi
) {

    suspend fun searchNewsByDate(environment: String): NewsResponse {
        return hackerNewsApi.getNewsByDate(environment)
    }

}