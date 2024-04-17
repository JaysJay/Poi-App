package com.sans.poi.data.remote

import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import com.sans.poi.utility.state.Resource

interface POIDataSource {
    suspend fun getSearch(request: ListPoint.Request) : Resource<ListPoint.Response>
    suspend fun getSuggestionWord(request: Suggestion.Request) : Resource<Suggestion.Response>
}