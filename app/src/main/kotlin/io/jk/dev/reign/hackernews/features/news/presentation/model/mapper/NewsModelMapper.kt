package io.jk.dev.reign.hackernews.features.news.presentation.model.mapper

import io.jk.dev.reign.hackernews.core.utils.TimeUtils
import io.jk.dev.reign.hackernews.features.news.domain.model.News
import io.jk.dev.reign.hackernews.features.news.presentation.model.NewsItemModel

class NewsModelMapper {

    fun map(news: News) = NewsItemModel(
        objectId = news.objectId,
        title = news.storyTitle ?: news.title ?: "-",
        createdAt = news.createdAt,
        authorAndCreatedAt = parseAuthorPlusDateAgo(news.author, news.createdAtI.toLong()),
        url = news.storyUrl ?: "-"
    )

    private fun parseAuthorPlusDateAgo(author: String, createdAt: Long): String {
        return "$author - ${parseTimeAgo(createdAt)}"
    }

    private fun parseTimeAgo(createdAt: Long) = TimeUtils.getTimeAgo(createdAt).orEmpty()

}