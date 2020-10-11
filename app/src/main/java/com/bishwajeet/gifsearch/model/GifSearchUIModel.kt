package com.bishwajeet.gifsearch.model

data class GifSearchUIModel(
    val id: String,
    val image_url: String
) {
    constructor(gifDataModel: GifDataModel) : this(
        id = gifDataModel.id,
        image_url = gifDataModel.image_url
    )
}