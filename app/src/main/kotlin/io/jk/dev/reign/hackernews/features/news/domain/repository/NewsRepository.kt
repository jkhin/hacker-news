package io.jk.dev.reign.hackernews.features.news.domain.repository

import io.jk.dev.reign.hackernews.features.news.domain.model.News

interface NewsRepository {
    suspend fun getNewsByDate(environment: String): List<News>
    suspend fun removeNew(objectId:String)
}