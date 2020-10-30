package io.jk.dev.reign.hackernews.features.news.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.jk.dev.reign.hackernews.R
import kotlinx.android.synthetic.main.fragment_web.*

class WebFragment : Fragment() {

    private val args : WebFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_web, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        initializeEvents()
        initializeWebView()
    }

    private fun initializeWebView() {
        val url = args.url
        if (args.url.isEmpty()) findNavController().popBackStack()
        wbDetail?.loadUrl(url)
    }

    private fun initializeEvents() {
        tvBack?.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}