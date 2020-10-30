package io.jk.dev.reign.hackernews.features.news.presentation.model.mapper

import io.jk.dev.reign.hackernews.core.utils.TimeUtils
import io.jk.dev.reign.hackernews.features.news.domain.model.Hits
import io.jk.dev.reign.hackernews.features.news.presentation.model.NewsItemModel

class NewsModelMapper {

    fun map(hits: Hits) = NewsItemModel(
        objectId = hits.objectId,
        title = hits.storyTitle ?: hits.title ?: "-",
        authorAndCreatedAt = parseAuthorPlusDateAgo(hits.author, hits.createdAtI.toLong()),
        url = hits.storyUrl ?: "-"
    )

    private fun parseAuthorPlusDateAgo(author: String, createdAt: Long): String {
        return "$author - ${parseTimeAgo(createdAt)}"
    }

    private fun parseTimeAgo(createdAt: Long) = TimeUtils.getTimeAgo(createdAt).orEmpty()

}