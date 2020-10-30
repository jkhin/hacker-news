package io.jk.dev.reign.hackernews

import android.app.Application
import io.jk.dev.reign.hackernews.di.injectModules

@SuppressWarnings("unused")
class HackerNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        injectModules(this)
    }

}