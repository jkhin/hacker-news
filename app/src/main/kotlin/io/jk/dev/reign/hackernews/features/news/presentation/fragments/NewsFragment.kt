package io.jk.dev.reign.hackernews.features.news.presentation.fragments

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.jk.dev.reign.hackernews.R
import io.jk.dev.reign.hackernews.core.callbacks.SwipeToRefreshCallback
import io.jk.dev.reign.hackernews.features.news.presentation.adapters.NewsAdapter
import io.jk.dev.reign.hackernews.features.news.presentation.model.NewsItemModel
import io.jk.dev.reign.hackernews.features.news.presentation.viewmodel.NewsViewModel
import io.jk.dev.reign.hackernews.features.news.presentation.viewmodel.viewstate.NewsViewState
import kotlinx.android.synthetic.main.fragment_news.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFragment : Fragment(), NewsAdapter.Listener {

    private val newsViewModel by viewModel<NewsViewModel>()

    private val newsAdapter = NewsAdapter(this@NewsFragment)

    private val newsResponseDataObserver = Observer<NewsViewState> {
        when (it) {
            is NewsViewState.Success -> doOnSuccessRequest(it.items)
            is NewsViewState.OnLoading -> updateSwipeToRefreshState(it.isLoading)
            is NewsViewState.UnSuccessful -> doOnUnSuccessfulRequest()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        initializeViewModel()
        initializeRecyclerView()
        initializeViewEvents()
    }

    private fun initializeRecyclerView() {
        rvNews?.apply {
            val mLayoutManager =LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            layoutManager = mLayoutManager
            addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL))
            adapter = newsAdapter

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (mLayoutManager.findLastVisibleItemPosition() == mLayoutManager.itemCount.minus(1)) {
                        newsViewModel.fetchNews()
                    }
                }
            })
        }
    }

    private fun initializeViewEvents() {
        srlNews?.setOnRefreshListener {
            getAndUpdateNews()
        }

        val itemTouchHelper =
            ItemTouchHelper(object : SwipeToRefreshCallback(requireContext()) {
                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    newsAdapter.removeAt(viewHolder.adapterPosition)
                }
            })

        rvNews?.let { itemTouchHelper.attachToRecyclerView(it) }
    }

    private fun initializeViewModel() {
        newsViewModel.state.observe(viewLifecycleOwner, newsResponseDataObserver)
        getAndUpdateNews()
    }

    private fun doOnSuccessRequest(items: List<NewsItemModel>) {
        newsAdapter.clearAndAddAll(items)
    }

    private fun doOnUnSuccessfulRequest() {
        Toast.makeText(requireContext(), "Couldn't load data", Toast.LENGTH_SHORT).show()
    }

    private fun updateSwipeToRefreshState(isRefreshing: Boolean) {
        srlNews?.isRefreshing = isRefreshing
    }

    private fun getAndUpdateNews() {
        newsViewModel.getNews()
    }

    override fun goToWebPage(url: String?) {
        if (!url.isNullOrBlank() && Patterns.WEB_URL.matcher(url).matches()) {
            val action = NewsFragmentDirections.actionHomeFragmentToWebFragment(url)
            findNavController().navigate(action)
        } else {
            Toast.makeText(requireContext(), "The url format isn't correct!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun removeNews(objectId: String) {
        newsViewModel.removeNew(objectId)
    }
}