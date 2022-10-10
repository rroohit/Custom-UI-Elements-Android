package com.roh.practice.domain.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.roh.practice.domain.repository.GetRefreshedTokens
import com.roh.practice.domain.util.WorkerKeys
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

@HiltWorker
class DemoWorkManager
@AssistedInject
constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val repo : GetRefreshedTokens
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            withContext(Dispatchers.IO) {

                val str = repo.getRefreshedTokens()

                val outPutData = workDataOf(WorkerKeys.TOKEN_STR to str)

                Result.success(outPutData)
            }


        } catch (e: Exception) {
            Result.failure()
        }


    }

}