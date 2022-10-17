package com.roh.practice.domain.repository

import androidx.work.OneTimeWorkRequest
import com.roh.practice.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface GetRefreshedTokens {

    suspend fun getRefreshedTokens(): String

    suspend fun getNewToken(): Flow<Resource<String>>


}