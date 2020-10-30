package io.jk.dev.reign.hackernews.features.news.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jk.dev.reign.hackernews.R
import io.jk.dev.reign.hackernews.features.news.presentation.model.NewsItemModel
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val mLst: MutableList<NewsItemModel> = mutableListOf()

    interface Listener {
        fun goToWebPage(url: String)
    }

    fun clearAndAddAll(items: List<NewsItemModel>) {
        mLst.clear()
        mLst.addAll(items)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        mLst.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mLst[position])
    }

    override fun getItemCount(): Int = mLst.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: NewsItemModel) = with(itemView) {
//            if (adapterPosition < 0) return

            tvNewsTitle?.text = model.title
            tvNewsAuthorAndDate?.text = model.authorAndCreatedAt

            setOnClickListener {
                if (model.url.isNullOrBlank()) return@setOnClickListener
                goToWebPage(model.url)
            }

        }

        private fun goToWebPage(url: String) {
            listener.goToWebPage(url)
        }
    }

}