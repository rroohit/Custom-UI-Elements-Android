package com.roh.practice.data.repository

import com.roh.practice.domain.model.User
import com.roh.practice.domain.repository.GetRefreshedTokens
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import javax.inject.Inject

class GetRefreshedTokensImpl
@Inject
constructor(
    private val httpClient: HttpClient
) : GetRefreshedTokens {

    override suspend fun getRefreshedTokens(): String {
        val user: User = httpClient.get("https://jsonplaceholder.typicode.com/todos/1").body()

        println("stringBody => $user")

        return user.title
    }

}