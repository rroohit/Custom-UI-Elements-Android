package com.roh.practice.data.repository

import android.util.Log
import com.roh.practice.data.local.dao.TokenDao
import com.roh.practice.data.local.dto.TokenDto
import com.roh.practice.domain.model.User
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.util.MissingPageException
import com.roh.practice.domain.util.Resource
import com.roh.practice.domain.util.networkRequestHandler
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRefreshedTokensImpl
@Inject
constructor(
    private val httpClient: HttpClient,
    private val tokenDao: TokenDao,
) : GetRefreshedTokens {

    companion object {
        var count = 0
        var getRefreshedTokensCount = 0
        var throwException = true
    }

    override suspend fun getUserData(): User {
        val user: User = httpClient.get("https://jsonplaceholder.typicode.com/todos/1").body()
        if (throwException) {
            throw MissingPageException("need new token")
        }
        return user
    }

    @kotlin.jvm.Throws(MissingPageException::class)
    override suspend fun getRefreshedTokens(): String {
        getRefreshedTokensCount++
        val user: User = httpClient.get("https://jsonplaceholder.typicode.com/todos/1").body()

        Log.d("REPO_IMPL", "getRefreshedTokens: $getRefreshedTokensCount user token => $user")

//        if (throwException) {
//            throw MissingPageException("Invalid token")
//        }
        return user.title
    }


    override suspend fun getNewToken(): Flow<Resource<User>> =
        networkRequestHandler(
            loadFromLocalDB = {
                val user = User(
                    id = 1,
                    userId = "charlie",
                    title = "rohit",
                    completed = true
                )
                flow { emit(user) }
            },
            loadFromNetworkRequest = {
                throwException = true
                delay(2000L)
                getUserData()
            },
            saveNetworkResult = {
                count++
                Log.d("NETWORK_RESULT", "getNewToken: saveNetworkResult => count $count")
                //tokenDao.insertTokens(TokenDto(token = it))
                delay(2000L)
                flow { emit(it) }

            },
            onTokenExpire = {
                //get new token
                throwException = false
                delay(3000L)
                getRefreshedTokens()
            },
            afterNewTokenNetworkRequest = { newToken ->
                //we had new token get new data form network
                getUserData()

            }
        )

}