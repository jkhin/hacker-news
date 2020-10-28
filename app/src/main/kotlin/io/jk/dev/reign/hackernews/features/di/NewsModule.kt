package io.jk.dev.reign.hackernews.features.di

import io.jk.dev.reign.hackernews.core.network.core.NAMED_HACKER_NEWS_API
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.RemovedNewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.NewsCloudStore
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsEntityMapper
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsMapper
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val newsFeatureModule by lazy {
    module {

        single { NewsMapper() }
        single { NewsEntityMapper() }

        single { NewsCloudStore(get(named(NAMED_HACKER_NEWS_API))) }

        single { NewsDataStore() }
        single { RemovedNewsDataStore() }

//        viewModel { NewsViewModel(get(), get()) }

//        single { TermsMapper() }
//        single { TermsModelMapper() }
//
//        single { GetTermsUseCase(get()) }
//
//        single<TermsRepository> { TermsRepositoryImpl(get(), get()) }
//
//        single { TermsLocalStorage() }
    }
}