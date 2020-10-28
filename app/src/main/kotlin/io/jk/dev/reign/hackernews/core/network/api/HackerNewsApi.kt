package io.jk.dev.reign.hackernews.core.network.api

import retrofit2.http.GET
import retrofit2.http.Query

interface HackerNewsApi {

    @GET("search_by_date")
    suspend fun getNewsByDate(
        @Query("query") environment: String
    )

}