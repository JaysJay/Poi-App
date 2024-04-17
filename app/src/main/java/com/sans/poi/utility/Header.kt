package com.sans.poi.utility

import android.content.Context
import com.sans.poi.utility.Constant.API_KEY
import javax.inject.Inject

data class Header @Inject constructor(
    val context: Context
) {

    fun header():Map<String,String> {
        val map = HashMap<String, String>()

        map["X-User-Agent"] = "mobile"
        map["X-RapidAPI-Key"] = API_KEY
        map["X-RapidAPI-Host"] = "local-business-data.p.rapidapi.com"
        return map
    }
}