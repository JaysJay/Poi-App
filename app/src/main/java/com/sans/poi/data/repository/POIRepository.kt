package com.sans.poi.data.repository

import com.sans.poi.data.remote.POIApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class POIRepository @Inject constructor(
    private val api: POIApiService
) {
    companion object {
        private const val TAG = "POIRepository"
    }

    //get data
}