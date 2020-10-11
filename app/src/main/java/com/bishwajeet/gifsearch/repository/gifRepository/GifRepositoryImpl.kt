package com.bishwajeet.gifsearch.repository.gifRepository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bishwajeet.gifsearch.dataSource.remote.PagingDataSource
import com.bishwajeet.gifsearch.dataSource.remote.RemoteDataSource
import com.bishwajeet.gifsearch.model.GifDataModel
import com.bishwajeet.gifsearch.model.GifResponse
import com.bishwajeet.gifsearch.model.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GifRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): GifRepository {

    override suspend fun getRandomGif(): Result<GifDataModel> {
        return try {
            when (val result = remoteDataSource.getRandomGif()) {
                is Result.Success -> {
                    Result.Success(getGifModel(result.data))
                }
                is Result.Error -> Result.Error(result.exception)
                else -> Result.Error("Unknown Error")
            }
        } catch (error: Exception) {
            Result.Error(error.message!!)
        }
    }


    override suspend fun getGifById(id: String): Result<GifDataModel> {
        return try {
            when (val result = remoteDataSource.getGifById(id)) {
                is Result.Success -> {
                    Result.Success(getGifModel(result.data))
                }
                is Result.Error -> Result.Error(result.exception)
                else -> Result.Error("Unknown Error")
            }
        } catch (error: Exception) {
            Result.Error(error.message!!)
        }
    }


    override fun getGifSearchResultStream(query: String): Flow<PagingData<GifDataModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { PagingDataSource(remoteDataSource, query) }
        ).flow
    }


    private fun getGifModel(response: GifResponse): GifDataModel {
        return GifDataModel(
            id = response.data.id,
            title = response.data.title,
            gif_url = response.data.images.fixedWidth.url,
            image_url = response.data.images.fixedHeightSmallStill.url,
            rating = response.data.rating.toUpperCase()
        )
    }


    companion object {
        private const val NETWORK_PAGE_SIZE = 20
    }
}