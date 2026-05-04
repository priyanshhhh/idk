# StoryGrab – Telegram Story Downloader

A professional Android application built with Kotlin, Jetpack Compose, and TDLib to download Telegram stories.

## Features
- **Telegram Login**: Secure authentication via official TDLib.
- **Story Downloader**: Preview and download photo/video stories.
- **Watch List (Premium)**: Auto-check for new stories every 15 minutes.
- **Clean Architecture**: MVVM + Clean Architecture with Hilt DI.
- **Modern UI**: Jetpack Compose with Material 3 and Dark Mode.

## Setup Instructions

### 1. Telegram API Credentials
To use TDLib, you need to obtain an API ID and Hash from [my.telegram.org](https://my.telegram.org).
Create a `local.properties` file in the root directory and add:
```properties
telegram.api_id=YOUR_API_ID
telegram.api_hash=YOUR_API_HASH
```

### 2. TDLib Integration
This project is configured to use TDLib. You may need to download the native libraries (`.so` files) for your target architectures and place them in `app/src/main/jniLibs`.

### 3. Google Play Billing
For premium features, ensure you have a Google Play Console account and have set up the products with IDs matching those in the code.

## Tech Stack
- **Language**: Kotlin
- **UI**: Jetpack Compose
- **DI**: Hilt
- **Database**: Room
- **Background Tasks**: WorkManager
- **Networking**: OkHttp & Retrofit
- **Media**: ExoPlayer & Coil
- **Animations**: Lottie & Compose Animation

## Project Structure
- `data/`: Local and remote data sources, repository implementations.
- `domain/`: Business logic, models, and use cases.
- `presentation/`: UI components, screens, and ViewModels.
- `service/`: Background services and workers.
- `di/`: Dependency injection modules.
