package com.bishwajeet.gifsearch.model
import androidx.annotation.Keep

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@Keep
@JsonClass(generateAdapter = true)
data class GifResponse(
    val `data`: Data = Data(),
    val meta: Meta = Meta()
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Data(
        @Json(name = "bitly_gif_url")
        val bitlyGifUrl: String = "",
        @Json(name = "bitly_url")
        val bitlyUrl: String = "",
        val caption: String = "",
        @Json(name = "content_url")
        val contentUrl: String = "",
        @Json(name = "embed_url")
        val embedUrl: String = "",
        @Json(name = "fixed_height_downsampled_height")
        val fixedHeightDownsampledHeight: String = "",
        @Json(name = "fixed_height_downsampled_url")
        val fixedHeightDownsampledUrl: String = "",
        @Json(name = "fixed_height_downsampled_width")
        val fixedHeightDownsampledWidth: String = "",
        @Json(name = "fixed_height_small_height")
        val fixedHeightSmallHeight: String = "",
        @Json(name = "fixed_height_small_still_url")
        val fixedHeightSmallStillUrl: String = "",
        @Json(name = "fixed_height_small_url")
        val fixedHeightSmallUrl: String = "",
        @Json(name = "fixed_height_small_width")
        val fixedHeightSmallWidth: String = "",
        @Json(name = "fixed_width_downsampled_height")
        val fixedWidthDownsampledHeight: String = "",
        @Json(name = "fixed_width_downsampled_url")
        val fixedWidthDownsampledUrl: String = "",
        @Json(name = "fixed_width_downsampled_width")
        val fixedWidthDownsampledWidth: String = "",
        @Json(name = "fixed_width_small_height")
        val fixedWidthSmallHeight: String = "",
        @Json(name = "fixed_width_small_still_url")
        val fixedWidthSmallStillUrl: String = "",
        @Json(name = "fixed_width_small_url")
        val fixedWidthSmallUrl: String = "",
        @Json(name = "fixed_width_small_width")
        val fixedWidthSmallWidth: String = "",
        val id: String = "",
        @Json(name = "image_frames")
        val imageFrames: String = "",
        @Json(name = "image_height")
        val imageHeight: String = "",
        @Json(name = "image_mp4_url")
        val imageMp4Url: String = "",
        @Json(name = "image_original_url")
        val imageOriginalUrl: String = "",
        @Json(name = "image_url")
        val imageUrl: String = "",
        @Json(name = "image_width")
        val imageWidth: String = "",
        val images: Images = Images(),
        @Json(name = "import_datetime")
        val importDatetime: String = "",
        @Json(name = "is_sticker")
        val isSticker: Int = 0,
        val rating: String = "",
        val slug: String = "",
        val source: String = "",
        @Json(name = "source_post_url")
        val sourcePostUrl: String = "",
        @Json(name = "source_tld")
        val sourceTld: String = "",
        val title: String = "",
        @Json(name = "trending_datetime")
        val trendingDatetime: String = "",
        val type: String = "",
        val url: String = "",
        val user: User = User(),
        val username: String = ""
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Images(
            val downsized: Downsized = Downsized(),
            @Json(name = "downsized_large")
            val downsizedLarge: DownsizedLarge = DownsizedLarge(),
            @Json(name = "downsized_medium")
            val downsizedMedium: DownsizedMedium = DownsizedMedium(),
            @Json(name = "downsized_small")
            val downsizedSmall: DownsizedSmall = DownsizedSmall(),
            @Json(name = "downsized_still")
            val downsizedStill: DownsizedStill = DownsizedStill(),
            @Json(name = "fixed_height")
            val fixedHeight: FixedHeight = FixedHeight(),
            @Json(name = "fixed_height_downsampled")
            val fixedHeightDownsampled: FixedHeightDownsampled = FixedHeightDownsampled(),
            @Json(name = "fixed_height_small")
            val fixedHeightSmall: FixedHeightSmall = FixedHeightSmall(),
            @Json(name = "fixed_height_small_still")
            val fixedHeightSmallStill: FixedHeightSmallStill = FixedHeightSmallStill(),
            @Json(name = "fixed_height_still")
            val fixedHeightStill: FixedHeightStill = FixedHeightStill(),
            @Json(name = "fixed_width")
            val fixedWidth: FixedWidth = FixedWidth(),
            @Json(name = "fixed_width_downsampled")
            val fixedWidthDownsampled: FixedWidthDownsampled = FixedWidthDownsampled(),
            @Json(name = "fixed_width_small")
            val fixedWidthSmall: FixedWidthSmall = FixedWidthSmall(),
            @Json(name = "fixed_width_small_still")
            val fixedWidthSmallStill: FixedWidthSmallStill = FixedWidthSmallStill(),
            @Json(name = "fixed_width_still")
            val fixedWidthStill: FixedWidthStill = FixedWidthStill(),
            val looping: Looping = Looping(),
            val original: Original = Original(),
            @Json(name = "original_mp4")
            val originalMp4: OriginalMp4 = OriginalMp4(),
            @Json(name = "original_still")
            val originalStill: OriginalStill = OriginalStill(),
            val preview: Preview = Preview(),
            @Json(name = "preview_gif")
            val previewGif: PreviewGif = PreviewGif(),
            @Json(name = "preview_webp")
            val previewWebp: PreviewWebp = PreviewWebp(),
            @Json(name = "480w_still")
            val wStill: WStill = WStill()
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Downsized(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedLarge(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedMedium(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedSmall(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class DownsizedStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeight(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightDownsampled(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightSmall(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightSmallStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedHeightStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidth(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthDownsampled(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthSmall(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthSmallStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class FixedWidthStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Looping(
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Original(
                val frames: String = "",
                val hash: String = "",
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val size: String = "",
                val url: String = "",
                val webp: String = "",
                @Json(name = "webp_size")
                val webpSize: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class OriginalMp4(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class OriginalStill(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Preview(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class PreviewGif(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class PreviewWebp(
                val height: String = "",
                val size: String = "",
                val url: String = "",
                val width: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class WStill(
                val height: String = "",
                val url: String = "",
                val width: String = ""
            )
        }

        @Keep
        @JsonClass(generateAdapter = true)
        data class User(
            @Json(name = "avatar_url")
            val avatarUrl: String = "",
            @Json(name = "banner_image")
            val bannerImage: String = "",
            @Json(name = "banner_url")
            val bannerUrl: String = "",
            @Json(name = "display_name")
            val displayName: String = "",
            @Json(name = "is_verified")
            val isVerified: Boolean = false,
            @Json(name = "profile_url")
            val profileUrl: String = "",
            val username: String = ""
        )
    }

    @Keep
    @JsonClass(generateAdapter = true)
    data class Meta(
        val msg: String = "",
        @Json(name = "response_id")
        val responseId: String = "",
        val status: Int = 0
    )
}