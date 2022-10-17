package com.roh.practice.domain.repository

import com.roh.practice.domain.model.User
import com.roh.practice.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetRefreshedTokens {

    suspend fun getUserData(): User

    suspend fun getRefreshedTokens(): String

    suspend fun getNewToken(): Flow<Resource<User>>


}