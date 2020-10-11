package com.bishwajeet.gifsearch.dataService.remote.apiService

import com.bishwajeet.gifsearch.model.GifResponse
import com.bishwajeet.gifsearch.model.GifSearchResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface APIService {

    companion object Factory {

        private const val BASE_URL = "https://api.giphy.com/v1/gifs/"

        private val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("Accept", "application/json")
                    builder.header("content-type", "application/json")

                    return@Interceptor chain.proceed(builder.build())
                }
            ).callTimeout(30, TimeUnit.SECONDS)
        }.build()


        fun create(): APIService {

            return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .build()
                .create(APIService::class.java)
        }
    }


    @GET("random")
    fun getRandomGif(
        @Query(value = "api_key") apiKey: String
    ): Deferred<Response<GifResponse>>


    @GET("{gif_id}")
    fun getGifById(
        @Path(value = "gif_id") gifId: String,
        @Query(value = "api_key") apiKey: String
    ): Deferred<Response<GifResponse>>


    @GET("search")
    fun gifSearch(
        @Query(value = "api_key") apiKey: String,
        @Query(value = "q") q: String,
        @Query(value = "limit") limit: Int,
        @Query(value = "offset") offset: Int
    ): Deferred<Response<GifSearchResponse>>
}