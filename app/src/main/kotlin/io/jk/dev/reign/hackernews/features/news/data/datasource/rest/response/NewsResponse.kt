package io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsResponse (
    val hits : List<HitsResponse>,
    val nbHits : Int,
    val page : Int,
    val nbPages : Int,
    val hitsPerPage : Int,
    val exhaustiveNbHits : Boolean,
    val query : String,
    val params : String,
    val processingTimeMS : Int
)