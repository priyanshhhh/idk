package com.storygrab.telegramdownloader.presentation.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
    object Login : Screen("login")
    object Home : Screen("home")
    object StoryPreview : Screen("story_preview/{storyId}") {
        fun createRoute(storyId: Int) = "story_preview/$storyId"
    }
    object WatchList : Screen("watch_list")
    object Downloads : Screen("downloads")
    object Settings : Screen("settings")
    object Paywall : Screen("paywall")
}
