package com.bishwajeet.gifsearch.dataSource.remote

import com.bishwajeet.gifsearch.dataService.remote.apiService.APIService
import com.bishwajeet.gifsearch.dataSource.local.LocalDataSource
import com.bishwajeet.gifsearch.model.GifResponse
import com.bishwajeet.gifsearch.model.GifSearchResponse
import com.bishwajeet.gifsearch.model.Result
import okhttp3.Credentials
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val apiService: APIService
): RemoteDataSource {


    override suspend fun getRandomGif(): Result<GifResponse> {
        return try {
            val apiKey = when (val apiKeyResult = localDataSource.getAPIKey()) {
                is Result.Success -> apiKeyResult.data
                is Result.Error -> ""
            }

            val response : Response<GifResponse> = apiService.getRandomGif(apiKey).await()

            if(response.isSuccessful && response.body() != null) {
                val responseObject = response.body() as GifResponse
                Result.Success(responseObject)
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }


    override suspend fun getGifById(id: String): Result<GifResponse> {
        return try {
            val apiKey = when (val apiKeyResult = localDataSource.getAPIKey()) {
                is Result.Success -> apiKeyResult.data
                is Result.Error -> ""
            }

            val response : Response<GifResponse> = apiService.getGifById(id, apiKey).await()

            if(response.isSuccessful && response.body() != null) {
                val responseObject = response.body() as GifResponse
                Result.Success(responseObject)
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }


    override suspend fun searchGif(
        searchQuery: String,
        limit: Int,
        offset: Int
    ): Result<GifSearchResponse> {
        return try {
            val apiKey = when (val apiKeyResult = localDataSource.getAPIKey()) {
                is Result.Success -> apiKeyResult.data
                is Result.Error -> ""
            }

            val response : Response<GifSearchResponse> = apiService.gifSearch(
                apiKey = apiKey,
                q = searchQuery,
                limit = limit,
                offset = offset
            ).await()

            if(response.isSuccessful && response.body() != null) {
                val responseObject = response.body() as GifSearchResponse
                Result.Success(responseObject)
            } else {
                Result.Error(response.message())
            }
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}