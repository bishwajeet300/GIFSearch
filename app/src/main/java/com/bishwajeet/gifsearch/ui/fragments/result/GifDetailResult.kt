package com.bishwajeet.gifsearch.ui.fragments.result

import com.bishwajeet.gifsearch.model.GifUIModel

data class GifDetailResult(
    val success: GifUIModel? = null,
    val error: String? = null
)