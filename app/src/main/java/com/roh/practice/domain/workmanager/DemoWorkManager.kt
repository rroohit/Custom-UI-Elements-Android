package com.roh.practice.domain.workmanager

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class DemoWorkManager
@AssistedInject
constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,

    ) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        return try {
            Result.success()

        } catch (e: Exception) {
            Result.failure()
        }

    }

}