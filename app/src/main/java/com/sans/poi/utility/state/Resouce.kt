package com.sans.poi.utility.state

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val code: Int = 200,
    val requestId: String = "",
) {
    class Nothing<T> : Resource<T>(code = 0)
    class Loading<T> : Resource<T>(code = 0)
    class Success<T>(data: T?,requestId: String = "") : Resource<T>(data, requestId = requestId)
    class Error<T>(
        message: String?,
        data: T? = null,
        code: Int = 500,
        requestIdHeader:String = "",
    ) : Resource<T>(data, message, code,requestIdHeader)
    class Transorm<T>(
        message: String? = null,
        data: T? = null,
        code: Int? = null
    ): Resource<T>(data, message, code = code?:0)

}