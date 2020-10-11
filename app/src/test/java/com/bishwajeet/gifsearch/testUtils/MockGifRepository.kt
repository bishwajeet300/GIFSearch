package com.bishwajeet.gifsearch.testUtils

import androidx.paging.PagingData
import com.bishwajeet.gifsearch.model.GifDataModel
import com.bishwajeet.gifsearch.model.Result
import com.bishwajeet.gifsearch.repository.gifRepository.GifRepository
import kotlinx.coroutines.flow.Flow

class MockGifRepository : GifRepository {
    override suspend fun getRandomGif(): Result<GifDataModel> {
        val model = GifDataModel(
            id = "test_id",
            title = "test_title",
            gif_url = "https://testgifurl.com/test.gif",
            image_url = "https://testgifurl.com/test.png",
            rating = ratingList[rand(ratingList.size)].toString()
        )

        return Result.Success(model)
    }

    override suspend fun getGifById(id: String): Result<GifDataModel> {
        val model = GifDataModel(
            id = id,
            title = "test_title",
            gif_url = "https://testgifurl.com/test.gif",
            image_url = "https://testgifurl.com/test.png",
            rating = ratingList[rand(ratingList.size)].toString()
        )

        return Result.Success(model)
    }

    override fun getGifSearchResultStream(query: String): Flow<PagingData<GifDataModel>> {
        TODO("Not yet implemented")
    }


    private fun rand(range: Int): Int {
        require(0 <= range) { "Illegal Argument" }
        return (Math.random() * (range - 1)).toInt()
    }

    companion object {
        val ratingList = listOf { "g"; "pg-13"; "pg"; "r" }
    }
}