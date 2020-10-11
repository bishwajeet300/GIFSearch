package com.bishwajeet.gifsearch.ui.fragments.search

import com.bishwajeet.gifsearch.ui.fragments.result.GifDetailAction

sealed class GifSearchAction {
    object ScreenOpen: GifSearchAction()
    data class SearchQueryInput(val query: String): GifSearchAction()
}