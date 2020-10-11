package com.bishwajeet.gifsearch.dataSource.remote

import com.bishwajeet.gifsearch.model.GifResponse
import com.bishwajeet.gifsearch.model.GifSearchResponse
import com.bishwajeet.gifsearch.model.Result

interface RemoteDataSource {

    /**
     * Fetches a single random GIF from remote network
     * */
    suspend fun getRandomGif(): Result<GifResponse>


    /**
     * Get GIF from remote network by ID returns a GIF’s metadata based on the GIF ID specified
     * */
    suspend fun getGifById(id: String): Result<GifResponse>


    /**
     * Fetches a list of GIFs from remote network based on the @param{searchQuery} provided
     * */
    suspend fun searchGif(searchQuery: String, limit: Int, offset: Int): Result<GifSearchResponse>
}