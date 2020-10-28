package io.jk.dev.reign.hackernews.features.di

import io.jk.dev.reign.hackernews.core.extensions.listByElementOf
import org.koin.core.module.Module

internal val featuresModule by lazy {
    listByElementOf<Module>(
        newsFeatureModule
    )
}