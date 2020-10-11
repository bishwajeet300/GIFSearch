package com.bishwajeet.gifsearch.dataService.local.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferencesManagerImpl @Inject constructor(
    @ApplicationContext private val context: Context
): PreferencesManager {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)


    override fun getAPIKey(): String {
        return preferences.getString(API_KEY, setAPIKey()).orEmpty()
    }

    private fun setAPIKey(): String {
        preferences.edit().putString(API_KEY, DEFAULT_API_KEY).apply()
        return DEFAULT_API_KEY
    }

    companion object {
        private const val PREFERENCES_FILE = "GifPreferences"
        private const val DEFAULT_API_KEY = "ucJ0zqZImd4MJgLWG95f9MzsfBqpWNRm"
        private const val API_KEY = "api_key"
    }
}