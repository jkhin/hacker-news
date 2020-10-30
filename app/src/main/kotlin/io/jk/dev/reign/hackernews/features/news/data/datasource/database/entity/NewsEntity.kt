package io.jk.dev.reign.hackernews.features.news.data.datasource.database.entity

import androidx.room.*

@Entity(tableName = "news_table")
data class NewsEntity(
	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	var id: Long,
	@ColumnInfo(name = "createdAt") 
	val createdAt: String,
	@ColumnInfo(name = "title")
	val title: String?,
	@ColumnInfo(name = "url")
	val url: String?,
	@ColumnInfo(name = "author")
	val author: String,
	@ColumnInfo(name = "points")
	val points: Int?,
	@ColumnInfo(name = "storyText")
	val storyText: String?,
	@ColumnInfo(name = "commentText")
	val commentText: String?,
	@ColumnInfo(name = "numComments")
	val numComments: Int?,
	@ColumnInfo(name = "storyId")
	val storyId: String?,
	@ColumnInfo(name = "storyTitle")
	val storyTitle: String?,
	@ColumnInfo(name = "storyUrl")
	val storyUrl: String?,
	@ColumnInfo(name = "parentId")
	val parentId: String?,
	@ColumnInfo(name = "createdAtI")
	val createdAtI: Int,
	@ColumnInfo(name = "tags")
	val tags: List<String>,
	@ColumnInfo(name = "objectId")
	val objectId: String,
	@ColumnInfo(name = "isRemoved")
	var isRemoved: Int = 0
)