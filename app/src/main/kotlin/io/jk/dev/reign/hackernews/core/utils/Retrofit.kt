package io.jk.dev.reign.hackernews.core.utils

import io.jk.dev.reign.hackernews.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


fun createHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(180, TimeUnit.SECONDS)
        .readTimeout(180, TimeUnit.SECONDS)
        .writeTimeout(180, TimeUnit.SECONDS)
        .build()
}

fun createRetrofit(httpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.HACKER_NEWS_API)
    .client(httpClient)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
