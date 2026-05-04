package com.storygrab.telegramdownloader.di

import android.content.Context
import androidx.room.Room
import com.storygrab.telegramdownloader.data.local.StoryDao
import com.storygrab.telegramdownloader.data.local.StoryDatabase
import com.storygrab.telegramdownloader.data.remote.TelegramClient
import com.storygrab.telegramdownloader.data.repository.StoryRepositoryImpl
import com.storygrab.telegramdownloader.domain.repository.StoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStoryDatabase(@ApplicationContext context: Context): StoryDatabase {
        return Room.databaseBuilder(
            context,
            StoryDatabase::class.java,
            "story_db"
        ).build()
    }

    @Provides
    fun provideStoryDao(database: StoryDatabase): StoryDao = database.storyDao()

    @Provides
    @Singleton
    fun provideTelegramClient(): TelegramClient {
        // In a real app, this would return the TDLib implementation
        return object : TelegramClient {
            override val authState = kotlinx.coroutines.flow.MutableStateFlow(com.storygrab.telegramdownloader.data.remote.AuthState.WaitPhoneNumber)
            override suspend fun setPhoneNumber(phoneNumber: String) {}
            override suspend fun checkAuthenticationCode(code: String) {}
            override suspend fun logOut() {}
            override suspend fun searchUser(username: String) = null
            override suspend fun getUserStories(userId: Long) = emptyList<com.storygrab.telegramdownloader.data.remote.TelegramStory>()
            override suspend fun downloadFile(fileId: Int, priority: Int) = null
        }
    }

    @Provides
    @Singleton
    fun provideStoryRepository(
        storyDao: StoryDao,
        telegramClient: TelegramClient
    ): StoryRepository = StoryRepositoryImpl(storyDao, telegramClient)
}
