package com.roh.practice.domain.util


class Resource<T> constructor(
    val status: Status = Status.LOADING,
    var data: T? = null,
    val message: String? = null,
) {

    companion object {

        fun <T> loading(data: T?): Resource<T> {
            return Resource(status = Status.LOADING, data = data, message = "loading")
        }

        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data = data, message = "success")
        }

        fun <T> error(message: String?, data: T?): Resource<T> {
            return Resource(status = Status.ERROR, data = data, message = message)
        }

        fun <T> cached(data: T?): Resource<T> {
            return Resource(status = Status.CACHED, data = data, message = "cached data")
        }

        fun <T> getNewTokens(): Resource<T> {
            return Resource(status = Status.NEEDNEWTOKEN)
        }

        fun <T> logout(): Resource<T> {
            return Resource(status = Status.LOGOUT, message = "Getting new token failed")
        }

    }

}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR,
    CACHED,
    NEEDNEWTOKEN,
    LOGOUT
}