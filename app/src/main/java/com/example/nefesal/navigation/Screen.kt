package com.example.nefesal.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Achievements : Screen("achievements")
    object Settings : Screen("settings")
} 