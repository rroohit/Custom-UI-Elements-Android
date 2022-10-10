package com.roh.practice.data.repository

import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.util.WorkerKeys
import com.roh.practice.domain.workmanager.DemoWorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetRefreshedTokensImpl
@Inject
constructor(
    private val workManager: WorkManager
) : GetRefreshedTokens {


    override suspend fun getRefreshedTokens(): OneTimeWorkRequest {

        val request = OneTimeWorkRequestBuilder<DemoWorkManager>()
            .addTag(WorkerKeys.TOKEN_WORKER)
            .build()

        workManager.enqueue(request)


        return request


    }

}