package io.jk.dev.reign.hackernews.core.network.api

import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HackerNewsApi {

    @GET("search_by_date")
    suspend fun getNewsByDate(
        @Query("page") page: Int,
        @Query("query") environment: String
    ): Response

}