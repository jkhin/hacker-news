package io.jk.dev.reign.hackernews

import android.app.Application
import io.jk.dev.reign.hackernews.core.db.HackerNewsDataBase
import io.jk.dev.reign.hackernews.core.db.HackerNewsDataBase.Companion.initializeDatabase
import io.jk.dev.reign.hackernews.di.injectModules

class HackerNewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
        initializeRoom()
    }

    private fun initializeKoin() {
        injectModules(this)
    }

    private fun initializeRoom() {
        HackerNewsDataBase.initializeDatabase(this)
    }

}