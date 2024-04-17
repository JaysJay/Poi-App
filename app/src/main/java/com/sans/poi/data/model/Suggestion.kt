package com.sans.poi.data.model

import com.google.gson.annotations.SerializedName

class Suggestion {
    data class Request(
        @field:SerializedName("query")
        val query: String? = null,

        @field:SerializedName("language")
        val language: String? = "en",

        @field:SerializedName("region")
        val region: String? = "us",

        @field:SerializedName("coordinates")
        val coordinates: String? = null,
    )

    data class Response(

        @field:SerializedName("data")
        val data: List<DataItem>? = null,

        @field:SerializedName("request_id")
        val requestId: String? = null,

        @field:SerializedName("parameters")
        val parameters: Parameters? = null,

        @field:SerializedName("status")
        val status: String? = null
    )

    data class MainTextHighlightsItem(

        @field:SerializedName("offset")
        val offset: Int? = null,

        @field:SerializedName("length")
        val length: Int? = null
    )

    data class SecondaryTextHighlightsItem(

        @field:SerializedName("offset")
        val offset: Int? = null,

        @field:SerializedName("length")
        val length: Int? = null
    )

    data class DataItem(

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("google_id")
        val googleId: String? = null,

        @field:SerializedName("secondary_text")
        val secondaryText: String? = null,

        @field:SerializedName("main_text_highlights")
        val mainTextHighlights: List<MainTextHighlightsItem>? = null,

        @field:SerializedName("latitude")
        val latitude: Double? = null,

        @field:SerializedName("description")
        val description: String? = null,

        @field:SerializedName("main_text")
        val mainText: String? = null,

        @field:SerializedName("secondary_text_highlights")
        val secondaryTextHighlights: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("place_id")
        val placeId: String? = null,

        @field:SerializedName("longitude")
        val longitude: Double? = null
    )

    data class Parameters(

        @field:SerializedName("query")
        val query: String? = null
    )
}