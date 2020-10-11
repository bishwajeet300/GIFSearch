package com.bishwajeet.gifsearch.dataSource.local

import com.bishwajeet.gifsearch.dataService.local.preferences.PreferencesManager
import com.bishwajeet.gifsearch.model.Result
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val preferencesManager: PreferencesManager
) : LocalDataSource {

    override fun getAPIKey(): Result<String> {
        return Result.Success(preferencesManager.getAPIKey())
    }
}