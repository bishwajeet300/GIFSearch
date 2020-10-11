package com.bishwajeet.gifsearch.dataService.remote.apiService

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class APIServiceModule {

    @Singleton
    @Provides
    fun provideAPIService(): APIService {
        return APIService.create()
    }
}