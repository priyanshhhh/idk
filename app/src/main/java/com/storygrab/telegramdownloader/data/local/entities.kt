package com.storygrab.telegramdownloader.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "watch_list")
data class WatchUserEntity(
    @PrimaryKey val userId: Long,
    val username: String,
    val displayName: String,
    val profilePhotoPath: String?,
    val lastCheckedTimestamp: Long = 0
)

@Entity(tableName = "download_history")
data class DownloadEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val telegramStoryId: Int,
    val userId: Long,
    val filePath: String,
    val mediaType: String, // PHOTO or VIDEO
    val timestamp: Long = System.currentTimeMillis()
)
