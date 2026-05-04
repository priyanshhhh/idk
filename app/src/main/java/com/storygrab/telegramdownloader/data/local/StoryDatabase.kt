package com.storygrab.telegramdownloader.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface StoryDao {
    @Query("SELECT * FROM watch_list")
    fun getWatchList(): Flow<List<WatchUserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToWatchList(user: WatchUserEntity)

    @Delete
    suspend fun removeFromWatchList(user: WatchUserEntity)

    @Query("SELECT * FROM download_history ORDER BY timestamp DESC")
    fun getDownloadHistory(): Flow<List<DownloadEntity>>

    @Insert
    suspend fun insertDownload(download: DownloadEntity)
}

@Database(entities = [WatchUserEntity::class, DownloadEntity::class], version = 1)
abstract class StoryDatabase : RoomDatabase() {
    abstract fun storyDao(): StoryDao
}
