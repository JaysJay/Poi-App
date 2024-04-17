package com.sans.poi.data.model

import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

class ListPoint {

    data class Request(
        @field:SerializedName("query")
        val query: String? = null,

        @field:SerializedName("limit")
        val limit: String? = "20",

        @field:SerializedName("lat")
        val lat: String? = null,

        @field:SerializedName("lng")
        val lng: String? = null,

        @field:SerializedName("zoom")
        val zoom: String? = "13",

        @field:SerializedName("language")
        val language: String? = "en",

        @field:SerializedName("region")
        val region: String? = "us",

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

    data class WorkingHours(

        @field:SerializedName("Thursday")
        val thursday: List<String?>? = null,

        @field:SerializedName("Monday")
        val monday: List<String?>? = null,

        @field:SerializedName("Friday")
        val friday: List<String?>? = null,

        @field:SerializedName("Sunday")
        val sunday: List<String?>? = null,

        @field:SerializedName("Wednesday")
        val wednesday: List<String?>? = null,

        @field:SerializedName("Tuesday")
        val tuesday: List<String?>? = null,

        @field:SerializedName("Saturday")
        val saturday: List<String?>? = null
    )

    data class Parameters(

        @field:SerializedName("lng")
        val lng: Double? = null,

        @field:SerializedName("offset")
        val offset: Int? = null,

        @field:SerializedName("query")
        val query: String? = null,

        @field:SerializedName("limit")
        val limit: Int? = null,

        @field:SerializedName("language")
        val language: String? = null,

        @field:SerializedName("zoom")
        val zoom: Int? = null,

        @field:SerializedName("region")
        val region: String? = null,

        @field:SerializedName("lat")
        val lat: Double? = null
    )

    data class PhotosSampleItem(

        @field:SerializedName("photo_timestamp")
        val photoTimestamp: Int? = null,

        @field:SerializedName("photo_id")
        val photoId: String? = null,

        @field:SerializedName("photo_url_large")
        val photoUrlLarge: String? = null,

        @field:SerializedName("latitude")
        val latitude: Double? = null,

        @field:SerializedName("photo_url")
        val photoUrl: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("photo_datetime_utc")
        val photoDatetimeUtc: String? = null,

        @field:SerializedName("video_thumbnail_url")
        val videoThumbnailUrl: String? = null,

        @field:SerializedName("longitude")
        val longitude: Double? = null
    )

    data class ReviewsPerRating(

        @field:SerializedName("1")
        val jsonMember1: Int? = null,

        @field:SerializedName("2")
        val jsonMember2: Int? = null,

        @field:SerializedName("3")
        val jsonMember3: Int? = null,

        @field:SerializedName("4")
        val jsonMember4: Int? = null,

        @field:SerializedName("5")
        val jsonMember5: Int? = null
    )

    data class DataItem(

        @field:SerializedName("street_address")
        val streetAddress: String? = null,

        @field:SerializedName("country")
        val country: String? = null,

        @field:SerializedName("google_id")
        val googleId: String? = null,

        @field:SerializedName("city")
        val city: String? = null,

        @field:SerializedName("google_mid")
        val googleMid: String? = null,

        @field:SerializedName("timezone")
        val timezone: String? = null,

        @field:SerializedName("owner_id")
        val ownerId: String? = null,

        @field:SerializedName("latitude")
        val latitude: Double? = null,

        @field:SerializedName("rating")
        val rating: Double? = null,

        @field:SerializedName("about")
        val about: About? = null,

        @field:SerializedName("review_count")
        val reviewCount: Int? = null,

        @field:SerializedName("full_address")
        val fullAddress: String? = null,

        @field:SerializedName("type")
        val type: String? = null,

        @field:SerializedName("subtypes")
        val subtypes: List<String?>? = null,

        @field:SerializedName("place_link")
        val placeLink: String? = null,

        @field:SerializedName("photos_sample")
        val photosSample: List<PhotosSampleItem>? = null,

        @field:SerializedName("reviews_per_rating")
        val reviewsPerRating: ReviewsPerRating? = null,

        @field:SerializedName("reviews_link")
        val reviewsLink: String? = null,

        @field:SerializedName("order_link")
        val orderLink: String? = null,

        @field:SerializedName("state")
        val state: String? = null,

        @field:SerializedName("place_id")
        val placeId: String? = null,

        @field:SerializedName("longitude")
        val longitude: Double? = null,

        @field:SerializedName("website")
        val website: String? = null,

        @field:SerializedName("owner_name")
        val ownerName: String? = null,

        @field:SerializedName("address")
        val address: String? = null,

        @field:SerializedName("business_status")
        val businessStatus: String? = null,

        @field:SerializedName("verified")
        val verified: Boolean? = null,

        @field:SerializedName("reservations_link")
        val reservationsLink: String? = null,

        @field:SerializedName("zipcode")
        val zipcode: String? = null,

        @field:SerializedName("owner_link")
        val ownerLink: String? = null,

        @field:SerializedName("photo_count")
        val photoCount: Int? = null,

        @field:SerializedName("price_level")
        val priceLevel: Any? = null,

        @field:SerializedName("working_hours")
        val workingHours: WorkingHours? = null,

        @field:SerializedName("booking_link")
        val bookingLink: String? = null,

        @field:SerializedName("district")
        val district: String? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("phone_number")
        val phoneNumber: String? = null,

        @field:SerializedName("business_id")
        val businessId: String? = null,

        @field:SerializedName("cid")
        val cid: String? = null
    )

    data class About(

        @field:SerializedName("summary")
        val summary: Any? = null,

        @field:SerializedName("details")
        val details: JsonElement? = null
    )
}