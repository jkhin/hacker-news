package io.jk.dev.reign.hackernews.features.news.data.mapper

import io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity.*
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response.*

class HitsEntityMapper {

    fun map(hits: List<HitsResponse>): List<NewsEntity> = hits.map {
        NewsEntity(
            createdAt = it.createdAt,
            title = it.title,
            url = it.url,
            author = it.author,
            points = it.points,
            storyId = it.storyId,
            storyText = it.storyText,
            storyTitle = it.storyTitle,
            storyUrl = it.storyUrl,
            commentText = it.commentText,
            createdAtI = it.createdAtI,
            objectID = it.objectID,
            numComments = it.numComments,
            parentId = it.parentId,
            tags = it.tags
        )
    }

}