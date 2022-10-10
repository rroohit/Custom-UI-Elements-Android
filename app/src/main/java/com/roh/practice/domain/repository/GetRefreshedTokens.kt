package com.roh.practice.domain.repository

import androidx.work.OneTimeWorkRequest

interface GetRefreshedTokens {

    suspend fun getRefreshedTokens(): String


}