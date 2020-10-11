package com.bishwajeet.gifsearch.dataService.local.preferences

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class PreferencesModule {

    @Binds
    abstract fun bindPreferenceManager(
        preferencesManagerImpl: PreferencesManagerImpl
    ): PreferencesManager
}