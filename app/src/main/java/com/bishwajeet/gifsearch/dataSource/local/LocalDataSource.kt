package com.bishwajeet.gifsearch.dataSource.local

import com.bishwajeet.gifsearch.model.Result

interface LocalDataSource {

    /**
     * Retrieves GIPHY API Key
     * */
    fun getAPIKey(): Result<String>
}