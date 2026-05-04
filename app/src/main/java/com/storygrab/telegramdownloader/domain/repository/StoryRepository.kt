package com.storygrab.telegramdownloader.domain.repository

import com.storygrab.telegramdownloader.data.local.WatchUserEntity
import com.storygrab.telegramdownloader.data.remote.TelegramStory
import com.storygrab.telegramdownloader.data.remote.TelegramUser
import kotlinx.coroutines.flow.Flow

interface StoryRepository {
    fun getWatchList(): Flow<List<WatchUserEntity>>
    suspend fun addToWatchList(user: WatchUserEntity)
    suspend fun removeFromWatchList(user: WatchUserEntity)
    suspend fun searchTelegramUser(username: String): TelegramUser?
    suspend fun getUserStories(userId: Long): List<TelegramStory>
    suspend fun downloadStory(fileId: Int): String?
}
