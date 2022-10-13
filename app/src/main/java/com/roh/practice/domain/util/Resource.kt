package com.roh.practice.domain.util


class Resource<T> constructor(
    val status: Status = Status.LOADING,
    var data: T? = null,
    val message: String? = null,
    val timestamp: Long? = null
) {

    companion object {

        fun <T> loading(data: T?): Resource<T> {
            return Resource(status = Status.LOADING, data = data, message = "loading")
        }

        fun <T> success(data: T?, timestamp: Long?): Resource<T> {
            return Resource(Status.SUCCESS, data = data, message = "success", timestamp = timestamp)
        }

        fun <T> error(msg: String?, data: T?, timestamp: Long?): Resource<T> {
            return Resource(status = Status.ERROR, data, message = msg, timestamp = timestamp)
        }

        fun <T> cached(data: T?, timestamp: Long?): Resource<T> {
            return Resource(status = Status.CACHED, data, message = "cache", timestamp = timestamp)
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