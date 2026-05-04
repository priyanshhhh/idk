package com.storygrab.telegramdownloader.data.repository

import com.storygrab.telegramdownloader.data.local.StoryDao
import com.storygrab.telegramdownloader.data.local.WatchUserEntity
import com.storygrab.telegramdownloader.data.remote.TelegramClient
import com.storygrab.telegramdownloader.domain.repository.StoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StoryRepositoryImpl @Inject constructor(
    private val storyDao: StoryDao,
    private val telegramClient: TelegramClient
) : StoryRepository {
    
    override fun getWatchList(): Flow<List<WatchUserEntity>> = storyDao.getWatchList()

    override suspend fun addToWatchList(user: WatchUserEntity) = storyDao.addToWatchList(user)

    override suspend fun removeFromWatchList(user: WatchUserEntity) = storyDao.removeFromWatchList(user)

    override suspend fun searchTelegramUser(username: String) = telegramClient.searchUser(username)

    override suspend fun getUserStories(userId: Long) = telegramClient.getUserStories(userId)
    
    override suspend fun downloadStory(fileId: Int) = telegramClient.downloadFile(fileId)
}
