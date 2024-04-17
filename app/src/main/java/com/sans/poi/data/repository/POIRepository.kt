package com.sans.poi.data.repository

import com.sans.poi.data.model.ListPoint
import com.sans.poi.data.model.Suggestion
import com.sans.poi.data.remote.POIApiService
import com.sans.poi.data.remote.POIDataSource
import com.sans.poi.data.remote.dataSource.POIRemoteDataSource
import com.sans.poi.utility.state.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import javax.inject.Inject
import javax.inject.Singleton


class POIRepository @Inject constructor(
    private val dataSource: POIRemoteDataSource
) : POIDataSource {
    companion object {
        private const val TAG = "POIRepository"
    }

    override suspend fun getSearch(request: ListPoint.Request): Resource<ListPoint.Response> {
        return withContext(Dispatchers.IO){
            dataSource.getSearch(request)
        }
    }

    override suspend fun getSuggestionWord(request: Suggestion.Request): Resource<Suggestion.Response> {
        return withContext(Dispatchers.IO){
            dataSource.getSuggestionWord(request)
        }
    }


}