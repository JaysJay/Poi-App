package com.sans.poi.data.remote.dataSource

import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import com.sans.poi.data.remote.POIApiService
import com.sans.poi.utility.Header
import com.sans.poi.utility.state.Resource
import javax.inject.Inject

class POIRemoteDataSource @Inject constructor(
    private val api: POIApiService,
    private val header: Header
) {

    suspend fun getSearch(
        request: ListPoint.Request
    ): Resource<ListPoint.Response>{
        val response =
            api.getSearch(
                header.header(),
                query = request.query,
                limit = request.limit,
                lat = request.lat,
                lng = request.lng,
                zoom = request.zoom,
                language = request.language,
                region = request.region
            )
        if (response.isSuccessful){
            response.body().let {
                return Resource.Success(it)
            }
        }else return Resource.Error(response.message())
    }

    suspend fun getSuggestionWord(
        request: Suggestion.Request
    ): Resource<Suggestion.Response>{
        val response =
            api.getSuggestionWord(
                header.header(),
                query = request.query,
                coordinate = request.coordinates,
                language = request.language,
                region = request.region
            )
        if (response.isSuccessful){
            response.body().let {
                return Resource.Success(it)
            }
        }else return Resource.Error(response.message())
    }
}