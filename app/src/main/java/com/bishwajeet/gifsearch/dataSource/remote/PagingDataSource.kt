package com.bishwajeet.gifsearch.dataSource.remote

import androidx.paging.PagingSource
import com.bishwajeet.gifsearch.model.GifDataModel
import com.bishwajeet.gifsearch.model.GifSearchResponse
import com.bishwajeet.gifsearch.model.Result
import retrofit2.HttpException
import java.io.IOException
import java.util.*

private const val GIF_STARTING_PAGE_INDEX = 1


class PagingDataSource(
    private val remoteDataSource: RemoteDataSource,
    private val query: String
) : PagingSource<Int, GifDataModel>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GifDataModel> {
        val position = params.key ?: GIF_STARTING_PAGE_INDEX
        val apiQuery = query
        return try {

            println("limit: ${params.loadSize}, offset: $position")
            val gifResponse = remoteDataSource.searchGif(
                searchQuery = apiQuery,
                limit = params.loadSize,
                offset = position
            )

            val gifs = getGifList(gifResponse)

            LoadResult.Page(
                data = gifs,
                prevKey = if (position == GIF_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (gifs.isEmpty()) null else position + params.loadSize
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }


    /**
     * Function for converting list of @param{GifSearchResponse} to list of @return{GifDataModel}
     * */
    private fun getGifList(response: Result<GifSearchResponse>): List<GifDataModel> {
        return run {
            when (response) {
                is Result.Success -> {
                    val gifDataList: MutableList<GifDataModel> = mutableListOf()
                    for (gif in response.data.data) {
                        gifDataList.add(
                            GifDataModel(
                                id = gif.id,
                                title = gif.title,
                                gif_url = gif.images.downsized.url,
                                image_url = gif.images.fixedHeightSmallStill.url,
                                rating = gif.rating.toUpperCase(Locale.ROOT)
                            )
                        )
                    }
                    gifDataList
                }
                is Result.Error -> {
                    listOf()
                }
            }
        }
    }
}