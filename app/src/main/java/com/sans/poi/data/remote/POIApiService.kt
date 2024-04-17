package com.sans.poi.data.remote

import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.Query

interface POIApiService {

    @GET("search")
    suspend fun getSearch(
        @HeaderMap header: Map<String,String>,
        @Query("query") query: String?,
        @Query("limit") limit: String?,
        @Query("lat") lat: String?,
        @Query("lng") lng: String?,
        @Query("zoom") zoom: String?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ) : Response<ListPoint.Response>

    @GET("autocomplete")
    suspend fun getSuggestionWord(
        @HeaderMap header: Map<String,String>,
        @Query("query") query: String?,
        @Query("coordinates") coordinate: String?,
        @Query("language") language: String?,
        @Query("region") region: String?
    ) : Response<Suggestion.Response>


}