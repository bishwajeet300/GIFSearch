package com.bishwajeet.gifsearch.ui.fragments.search

import com.bishwajeet.gifsearch.model.GifSearchUIModel

interface GifSelectionListener {
    fun onClick(gifSearchUIModel: GifSearchUIModel)
}