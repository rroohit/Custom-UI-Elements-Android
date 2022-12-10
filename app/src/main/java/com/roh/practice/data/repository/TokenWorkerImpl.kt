package com.roh.practice.data.repository

import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.roh.practice.domain.repository.TokenWorker
import com.roh.practice.domain.util.WorkerKeys
import com.roh.practice.domain.workmanager.DemoWorkManager
import javax.inject.Inject

class TokenWorkerImpl
@Inject
constructor(
    private val workManager: WorkManager
) : TokenWorker {

    override suspend fun getRefreshedTokenWorkRequest(): OneTimeWorkRequest {
        val request = OneTimeWorkRequestBuilder<DemoWorkManager>()
            .build()


        workManager.beginUniqueWork(
            WorkerKeys.TOKEN_WORKER,
            ExistingWorkPolicy.KEEP,
            request
        ).enqueue()


        return request
    }
}