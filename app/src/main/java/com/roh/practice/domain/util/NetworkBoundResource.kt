package com.roh.practice.domain.util

import io.ktor.client.plugins.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType, RequestType, NewToken> networkRequestHandler(
    crossinline loadFromLocalDB: () -> Flow<ResultType>,
    crossinline loadFromNetworkRequest: suspend () -> RequestType,
    crossinline saveNetworkResult: suspend (RequestType) -> Flow<ResultType>,
    crossinline onTokenExpire: suspend () -> NewToken,
    crossinline afterNewTokenNetworkRequest: suspend (NewToken) -> RequestType
)= flow {

    val localData = loadFromLocalDB().firstOrNull()

    emit(Resource.loading(localData))

    val resultFlow = try {
        val networkData = loadFromNetworkRequest()
        saveNetworkResult(networkData).map {
            Resource.success(it)
        }

    } catch (httpException: ServerResponseException) {

        if (httpException.response.status.value == 401){
            val newToken = onTokenExpire()
            val networkDataAfterNewToken = afterNewTokenNetworkRequest(newToken)
            saveNetworkResult(networkDataAfterNewToken).map {
                Resource.success(it)
            }
        } else {
            flow { emit(Resource.error(httpException.message, localData)) }

        }
    } catch (e: Exception) {

        flow { emit(Resource.error(e.message.toString(), localData)) }

    }

    emit(Resource.loading(localData))

}