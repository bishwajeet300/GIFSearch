package com.bishwajeet.gifsearch.ui.fragments.result

sealed class GifDetailAction {
    data class ScreenOpenWithId(val id: String): GifDetailAction()
}