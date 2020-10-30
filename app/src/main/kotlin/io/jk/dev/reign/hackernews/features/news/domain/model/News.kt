package io.jk.dev.reign.hackernews.features.news.domain.model

data class News (
	val createdAt : String,
	val title : String?,
	val url : String?,
	val author : String,
	val points : Int?,
	val storyText : String?,
	val commentText : String?,
	val numComments : Int?,
	val storyId : String?,
	val storyTitle : String?,
	val storyUrl : String?,
	val parentId : String?,
	val createdAtI : Int,
	val tags : List<String>,
	val objectId : String
)