package com.bishwajeet.gifsearch.repository.gifRepository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class GifRepositoryModule {

    @Binds
    abstract fun bindGifRepository(
        gifRepositoryImpl: GifRepositoryImpl
    ): GifRepository
}