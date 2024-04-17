package com.sans.poi.ui.viewModel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import com.bumptech.glide.load.HttpException
import com.sans.poi.PoiApp
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.IOException
import java.net.SocketException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(
    app: Application
) : AndroidViewModel(app) {

    protected val context
        get() = getApplication<Application>()

    protected fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<PoiApp>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(
            activeNetwork
        ) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

    fun handleException(e: Exception): String {
        return when (e) {
            is UnknownHostException, is SocketException -> {
                "Connection Problem"
            }
            is SocketTimeoutException -> {
                "Connection Timeout, Try Again."
            }
            is IOException -> "Failed to read response!"
            is HttpException -> "Error Code : ${e.statusCode}"
            is IOException -> "Failed to read response!"
            else -> e.message.toString()
        }
    }
}