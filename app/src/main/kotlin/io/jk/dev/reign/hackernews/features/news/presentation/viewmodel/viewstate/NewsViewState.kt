package io.jk.dev.reign.hackernews.features.news.presentation.viewmodel.viewstate

import io.jk.dev.reign.hackernews.features.news.presentation.model.NewsItemModel

open class NewsViewState {
    class Success(val items: List<NewsItemModel>) : NewsViewState()
    class OnLoading(val isLoading: Boolean) : NewsViewState()
    object UnSuccessful : NewsViewState()
}