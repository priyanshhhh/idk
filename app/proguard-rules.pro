# Hilt
-keep class dagger.hilt.android.internal.managers.** { *; }
-keep class * extends android.app.Application
-keep @dagger.hilt.android.HiltAndroidApp class *

# Room
-keep class * extends androidx.room.RoomDatabase

# TDLib
-keep class org.telegram.tdlib.** { *; }

# Lottie
-keep class com.airbnb.lottie.** { *; }
