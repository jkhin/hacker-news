package io.jk.dev.reign.hackernews.features.news.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jk.dev.reign.hackernews.core.extensions.io
import io.jk.dev.reign.hackernews.core.extensions.ui
import io.jk.dev.reign.hackernews.features.news.domain.interactor.NewsUseCase
import io.jk.dev.reign.hackernews.features.news.presentation.model.mapper.NewsModelMapper
import io.jk.dev.reign.hackernews.features.news.presentation.viewmodel.viewstate.NewsViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsUseCase: NewsUseCase,
    private val newsModelMapper: NewsModelMapper
) : ViewModel() {

    val state: LiveData<NewsViewState>
        get() = _state

    private var _state = MutableLiveData<NewsViewState>()

    private var nPage: Int = 0


    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        ui {
            exception.printStackTrace()
            _state.value = NewsViewState.OnLoading(false)
            _state.value = NewsViewState.UnSuccessful
        }
    }

    fun getNews() {
        viewModelScope.launch(errorHandler) {
            io {
                val news = newsUseCase.getNews(nPage)
                val items = news.map(newsModelMapper::map)

                ui {
                    _state.value = NewsViewState.OnLoading(false)
                    _state.value = NewsViewState.Success(items)
                }
                nPage++
            }
        }
    }

    fun fetchNews() {
        viewModelScope.launch(errorHandler) {
            io {
                val news = newsUseCase.getNews(nPage)
                val items = news.map(newsModelMapper::map)

                ui {
                    _state.value = NewsViewState.OnLoading(false)
                    _state.value = NewsViewState.Success(items)
                }
                nPage++
            }
        }
    }

    fun removeNew(objectId: String) {
        viewModelScope.launch(errorHandler) {
            io {
                newsUseCase.removeNew(objectId)
            }
        }
    }

}