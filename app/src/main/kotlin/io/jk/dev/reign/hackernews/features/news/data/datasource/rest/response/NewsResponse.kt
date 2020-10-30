package io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse(
    @Json(name = "created_at") val createdAt: String,
    val title: String?,
    val url: String?,
    val author: String,
    val points: Int?,
    val storyText: String?,
    @Json(name = "comment_text") val commentText: String?,
    @Json(name = "num_comments") val numComments: Int?,
    @Json(name = "story_id") val storyId: String?,
    @Json(name = "story_title") val storyTitle: String?,
    @Json(name = "story_url") val storyUrl: String?,
    @Json(name = "parent_id") val parentId: String?,
    @Json(name = "created_at_i") val createdAtI: Int,
    @Json(name = "_tags") val tags: List<String>,
    val objectID: String
)