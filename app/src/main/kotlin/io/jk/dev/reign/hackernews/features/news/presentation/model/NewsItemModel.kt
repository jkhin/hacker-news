package io.jk.dev.reign.hackernews.features.news.presentation.model

data class NewsItemModel(
    val objectId: String,
    val authorAndCreatedAt: String,
    val createdAt: String,
    val title: String,
    val url: String?
)