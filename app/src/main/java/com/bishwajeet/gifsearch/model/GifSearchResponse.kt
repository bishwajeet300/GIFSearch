package com.bishwajeet.gifsearch.model
import androidx.annotation.Keep

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@Keep
@JsonClass(generateAdapter = true)
data class GifSearchResponse(
    val `data`: List<Data> = listOf(),
    val meta: Meta = Meta(),
    val pagination: Pagination = Pagination()
) {
    @Keep
    @JsonClass(generateAdapter = true)
    data class Data(
        val analytics: Analytics = Analytics(),
        @Json(name = "analytics_response_payload")
        val analyticsResponsePayload: String = "",
        @Json(name = "bitly_gif_url")
        val bitlyGifUrl: String = "",
        @Json(name = "bitly_url")
        val bitlyUrl: String = "",
        @Json(name = "content_url")
        val contentUrl: String = "",
        @Json(name = "embed_url")
        val embedUrl: String = "",
        @Json(name = "featured_tags")
        val featuredTags: List<Any> = listOf(),
        val id: String = "",
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
        val tags: List<Any> = listOf(),
        val title: String = "",
        @Json(name = "trending_datetime")
        val trendingDatetime: String = "",
        val type: String = "",
        val url: String = "",
        val user: User = User(),
        @Json(name = "user_tags")
        val userTags: List<Any> = listOf(),
        val username: String = ""
    ) {
        @Keep
        @JsonClass(generateAdapter = true)
        data class Analytics(
            val onclick: Onclick = Onclick(),
            val onload: Onload = Onload(),
            val onsent: Onsent = Onsent()
        ) {
            @Keep
            @JsonClass(generateAdapter = true)
            data class Onclick(
                val url: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Onload(
                val url: String = ""
            )

            @Keep
            @JsonClass(generateAdapter = true)
            data class Onsent(
                val url: String = ""
            )
        }

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
            val hd: Hd = Hd(),
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
            data class Hd(
                val height: String = "",
                val mp4: String = "",
                @Json(name = "mp4_size")
                val mp4Size: String = "",
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
                val size: String = "",
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

    @Keep
    @JsonClass(generateAdapter = true)
    data class Pagination(
        val count: Int = 0,
        val offset: Int = 0,
        @Json(name = "total_count")
        val totalCount: Int = 0
    )
}