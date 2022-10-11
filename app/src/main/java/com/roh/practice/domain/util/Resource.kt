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

        fun <T> reAuthenticate(): Resource<T> {
            return Resource(status = Status.REAUTH)
        }

        fun <T> logout(): Resource<T> {
            return Resource(status = Status.LOGOUT)
        }

    }

}

enum class Status {
    LOADING,
    SUCCESS,
    ERROR,
    CACHED,
    REAUTH,
    LOGOUT
}