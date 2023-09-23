package com.evolver.eventsapp.utils

const val BASE_URL = "http://54.162.80.249/"

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val exception : Exception? = null
) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(errorMessage: String) : Resource<T>(message = errorMessage)

    class Failure<T>(exception: Exception) : Resource<T>(exception = exception)
    class Loading<T> : Resource<T>()

    class Timeout<T> : Resource<T>()
}