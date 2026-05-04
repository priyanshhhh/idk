package com.storygrab.telegramdownloader.data.remote

import kotlinx.coroutines.flow.Flow

/**
 * Interface representing the TDLib client wrapper.
 * In a real implementation, this would interact with the native TDLib library.
 */
interface TelegramClient {
    val authState: Flow<AuthState>
    
    suspend fun setPhoneNumber(phoneNumber: String)
    suspend fun checkAuthenticationCode(code: String)
    suspend fun logOut()
    
    suspend fun searchUser(username: String): TelegramUser?
    suspend fun getUserStories(userId: Long): List<TelegramStory>
    suspend fun downloadFile(fileId: Int, priority: Int = 1): String?
}

sealed class AuthState {
    object Uninitialized : AuthState()
    object WaitPhoneNumber : AuthState()
    object WaitCode : AuthState()
    object Ready : AuthState()
    data class Error(val message: String) : AuthState()
}

data class TelegramUser(
    val id: Long,
    val username: String?,
    val firstName: String,
    val lastName: String,
    val profilePhotoPath: String?
)

data class TelegramStory(
    val id: Int,
    val userId: Long,
    val mediaType: String,
    val thumbnailPath: String?,
    val contentPath: String?,
    val timestamp: Int
)
