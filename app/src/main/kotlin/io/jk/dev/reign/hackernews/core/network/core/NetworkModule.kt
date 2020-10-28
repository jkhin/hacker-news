package io.jk.dev.reign.hackernews.core.network.core

import io.jk.dev.reign.hackernews.core.network.api.HackerNewsApi
import io.jk.dev.reign.hackernews.core.utils.createHttpClient
import io.jk.dev.reign.hackernews.core.utils.createRetrofit
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

const val NAMED_HACKER_NEWS_CLIENT = "HACKER_NEWS_CLIENT"
const val NAMED_HACKER_NEWS = "HACKER_NEWS"
const val NAMED_HACKER_NEWS_API = "HACKER_NEWS_API"

internal val networkModule by lazy {

    module {
        single(named(NAMED_HACKER_NEWS_CLIENT)) { createHttpClient() }

        single(named(NAMED_HACKER_NEWS)) {
            createRetrofit(
                get(named(NAMED_HACKER_NEWS_CLIENT))
            )
        }

        single(named(NAMED_HACKER_NEWS_API)) { provideHackerNewsApi(get(named(NAMED_HACKER_NEWS))) }
    }

}

fun provideHackerNewsApi(retrofit: Retrofit): HackerNewsApi {
    return retrofit.create(HackerNewsApi::class.java)
}