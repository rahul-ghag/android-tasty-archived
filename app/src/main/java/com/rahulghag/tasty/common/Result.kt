package com.rahulghag.tasty.common

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    object NetworkError : Result<Nothing>()
    data class Error(val code: Int? = null, val errorMessage: String? = null) : Result<Nothing>()
}