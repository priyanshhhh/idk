package com.storygrab.telegramdownloader.domain.usecase

import com.storygrab.telegramdownloader.domain.repository.StoryRepository
import javax.inject.Inject

class GetWatchListUseCase @Inject constructor(private val repository: StoryRepository) {
    operator fun invoke() = repository.getWatchList()
}

class SearchUserUseCase @Inject constructor(private val repository: StoryRepository) {
    suspend operator fun invoke(username: String) = repository.searchTelegramUser(username)
}

class GetUserStoriesUseCase @Inject constructor(private val repository: StoryRepository) {
    suspend operator fun invoke(userId: Long) = repository.getUserStories(userId)
}

class DownloadStoryUseCase @Inject constructor(private val repository: StoryRepository) {
    suspend operator fun invoke(fileId: Int) = repository.downloadStory(fileId)
}
