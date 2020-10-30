package io.jk.dev.reign.hackernews.features.di

import io.jk.dev.reign.hackernews.core.network.core.NAMED_HACKER_NEWS_API
import io.jk.dev.reign.hackernews.features.news.data.datasource.database.NewsDataStore
import io.jk.dev.reign.hackernews.features.news.data.datasource.rest.NewsCloudStore
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsEntityMapper
import io.jk.dev.reign.hackernews.features.news.data.mapper.NewsMapper
import io.jk.dev.reign.hackernews.features.news.data.repository.NewsRepositoryImpl
import io.jk.dev.reign.hackernews.features.news.domain.interactor.NewsUseCase
import io.jk.dev.reign.hackernews.features.news.domain.repository.NewsRepository
import io.jk.dev.reign.hackernews.features.news.presentation.model.mapper.NewsModelMapper
import io.jk.dev.reign.hackernews.features.news.presentation.viewmodel.NewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val newsFeatureModule by lazy {
    module {

        viewModel { NewsViewModel(get(), get()) }

        single { NewsModelMapper() }

        single { NewsUseCase(get()) }

        single { NewsEntityMapper() }
        single { NewsMapper() }

        single { NewsCloudStore(get(named(NAMED_HACKER_NEWS_API))) }

        single { NewsDataStore() }

        single<NewsRepository> { NewsRepositoryImpl(get(), get(), get(), get()) }

    }
}