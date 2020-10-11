package com.bishwajeet.gifsearch.repository.gifRepository

import androidx.paging.PagingData
import com.bishwajeet.gifsearch.model.GifDataModel
import com.bishwajeet.gifsearch.model.Result
import kotlinx.coroutines.flow.Flow

interface GifRepository {

    /**
     * Fetches a single random GIF
     * */
    suspend fun getRandomGif(): Result<GifDataModel>


    /**
     * Get GIF by ID returns a GIF’s metadata based on the GIF ID specified
     * */
    suspend fun getGifById(id: String): Result<GifDataModel>


    /**
     * Fetches a list of GIFs based on the @param{query} provided. Return a Flow of PagingData
     * */
    fun getGifSearchResultStream(query: String): Flow<PagingData<GifDataModel>>
}