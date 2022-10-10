package com.roh.practice.domain.repository

import androidx.work.OneTimeWorkRequest

interface TokenWorker {
    suspend fun getRefreshedTokenWorkRequest(): OneTimeWorkRequest

}