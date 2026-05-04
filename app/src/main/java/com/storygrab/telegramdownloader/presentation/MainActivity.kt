package com.storygrab.telegramdownloader.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.storygrab.telegramdownloader.presentation.navigation.Screen
import com.storygrab.telegramdownloader.presentation.theme.StoryGrabTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoryGrabTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        // Add Bottom Navigation Bar here
                    }
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Splash.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Splash.route) { /* SplashScreen() */ }
                        composable(Screen.Onboarding.route) { /* OnboardingScreen() */ }
                        composable(Screen.Login.route) { /* LoginScreen() */ }
                        composable(Screen.Home.route) { /* HomeScreen() */ }
                        composable(Screen.StoryPreview.route) { /* StoryPreviewScreen() */ }
                        composable(Screen.WatchList.route) { /* WatchListScreen() */ }
                        composable(Screen.Downloads.route) { /* DownloadsScreen() */ }
                        composable(Screen.Settings.route) { /* SettingsScreen() */ }
                        composable(Screen.Paywall.route) { /* PaywallScreen() */ }
                    }
                }
            }
        }
    }
}
