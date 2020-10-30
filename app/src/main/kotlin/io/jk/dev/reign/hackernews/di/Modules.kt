package io.jk.dev.reign.hackernews.di

import android.app.Application
import io.jk.dev.reign.hackernews.core.extensions.listByElementOf
import io.jk.dev.reign.hackernews.core.network.core.networkModule
import io.jk.dev.reign.hackernews.features.di.featuresModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

internal fun injectModules(app: Application) {
    startKoin{
        androidLogger()
        androidContext(app)
        koin.loadModules(applicationModules)
        koin.createRootScope()
    }
}

internal val applicationModules by lazy {
    listByElementOf<Module>(
        featuresModule,
        networkModule
    )
}