package com.storygrab.telegramdownloader.service

import android.content.Context
import androidx.work.*
import com.storygrab.telegramdownloader.domain.repository.StoryRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit

class StoryCheckWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: StoryRepository
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        // Implementation for checking new stories for users in watch list
        // and showing notifications if new stories are found.
        return Result.success()
    }

    companion object {
        fun enqueuePeriodicWork(context: Context) {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val request = PeriodicWorkRequestBuilder<StoryCheckWorker>(15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()

            WorkManager.getInstance(context).enqueueUniquePeriodicWork(
                "StoryCheckWork",
                ExistingPeriodicWorkPolicy.KEEP,
                request
            )
        }
    }
}
