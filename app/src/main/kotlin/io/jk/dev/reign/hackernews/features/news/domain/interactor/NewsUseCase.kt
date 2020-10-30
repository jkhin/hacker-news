package io.jk.dev.reign.hackernews.features.news.domain.interactor

import io.jk.dev.reign.hackernews.features.news.domain.model.News
import io.jk.dev.reign.hackernews.features.news.domain.repository.NewsRepository

class NewsUseCase(
    private val newsRepository: NewsRepository
) {

    companion object {
        private const val ENVIRONMENT = "android"
    }

    suspend fun getNews(): List<News> = newsRepository.getNewsByDate(ENVIRONMENT)

    suspend fun removeNew(objectId: String) = newsRepository.removeNew(objectId)

}