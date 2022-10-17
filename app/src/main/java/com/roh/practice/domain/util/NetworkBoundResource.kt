package com.roh.practice.domain.util

import android.util.Log
import io.ktor.client.plugins.*
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType, NewToken> networkRequestHandler(
    crossinline loadFromLocalDB: () -> Flow<ResultType>,
    crossinline loadFromNetworkRequest: suspend () -> RequestType,
    crossinline saveNetworkResult: suspend (RequestType) -> Flow<ResultType>,
    crossinline onTokenExpire: suspend () -> NewToken,
    crossinline afterNewTokenNetworkRequest: suspend (NewToken) -> RequestType
) = flow {
    Log.d("NETWORK_BOUND", "networkRequestHandler: start")

    val localData = loadFromLocalDB().firstOrNull()

    emit(Resource.cached(localData))

    val resultFlow = try {
        val networkData = loadFromNetworkRequest()
        saveNetworkResult(networkData).map {
            Log.d("NETWORK_BOUND", "networkRequestHandler: result type 1 => $it")
            Resource.success(it)
        }

    } catch (e: Exception) {
        if (e.message == "need new token") {
            Log.d("NETWORK_BOUND", "networkRequestHandler: 1 error => ${e.message}")
            try {
                val newToken = onTokenExpire()
                saveNetworkResult(afterNewTokenNetworkRequest(newToken)).map {
                    Log.d("NETWORK_BOUND", "networkRequestHandler: result type 2 => $it")

                    Resource.success(it)
                }
            } catch (error: Exception) {
                Log.d("NETWORK_BOUND", "networkRequestHandler: 3 error => ${e.localizedMessage}")
                flow { emit(Resource.getNewTokens()) }

            }


        } else {
            Log.d("NETWORK_BOUND", "networkRequestHandler: 2 error => ${e.localizedMessage}")

            flow { emit(Resource.error("2 ${e.message}", localData)) }

        }

    }

    emitAll(resultFlow)

}