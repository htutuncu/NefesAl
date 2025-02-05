package com.example.nefesal.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.nefesal.navigation.Screen
import com.example.nefesal.ui.screens.achievements.AchievementsScreen
import com.example.nefesal.ui.screens.home.HomeScreen
import com.example.nefesal.ui.screens.settings.SettingsScreen
import com.example.nefesal.ui.screens.splash.SplashScreen
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.nefesal.ui.screens.home.HomeViewModel

@Composable
fun NefesAlApp(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val switchState by viewModel.isDarkMode.collectAsState()
    val coroutineScope = rememberCoroutineScope()


    val navController = rememberNavController()
    val items = listOf(
        Triple(Screen.Home, "Ana Sayfa", Icons.Default.Home),
        Triple(Screen.Achievements, "Kazanımlar", Icons.Default.Star),
        Triple(Screen.Settings, "Ayarlar", Icons.Default.Settings)
    )



    Scaffold(
        bottomBar = {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            
            if (currentDestination?.route != Screen.Splash.route) {
                NavigationBar(
                    containerColor = if (switchState) {
                        MaterialTheme.colorScheme.secondaryContainer
                    } else {
                        MaterialTheme.colorScheme.primaryContainer
                    }
                ) {
                    items.forEach { (screen, title, icon) ->
                        NavigationBarItem(
                            icon = { 
                                Icon(
                                    icon, 
                                    contentDescription = title,
                                    tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                        if (switchState) {
                                            MaterialTheme.colorScheme.onSecondaryContainer
                                        } else {
                                            MaterialTheme.colorScheme.onPrimaryContainer
                                        }
                                    } else {
                                        if (switchState) {
                                            MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.6f)
                                        } else {
                                            MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                                        }
                                    }
                                ) 
                            },
                            label = { 
                                Text(
                                    text = title,
                                    color = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                        if (switchState) {
                                            MaterialTheme.colorScheme.onSecondaryContainer
                                        } else {
                                            MaterialTheme.colorScheme.onPrimaryContainer
                                        }
                                    } else {
                                        if (switchState) {
                                            MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.6f)
                                        } else {
                                            MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.6f)
                                        }
                                    }
                                ) 
                            },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                            onClick = {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            composable(Screen.Splash.route) {
                SplashScreen(onSplashComplete = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                })
            }
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Achievements.route) { AchievementsScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
} 