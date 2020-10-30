package io.jk.dev.reign.hackernews.features.news.domain.repository

import io.jk.dev.reign.hackernews.features.news.domain.model.Hits

interface NewsRepository {
    suspend fun getNewsByDate(environment: String): List<Hits>
    suspend fun removeNew(objectId:String)
}