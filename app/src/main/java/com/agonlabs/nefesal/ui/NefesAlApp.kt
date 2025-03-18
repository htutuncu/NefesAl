package com.agonlabs.nefesal.ui

import android.os.Build
import androidx.annotation.RequiresApi
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
import com.agonlabs.nefesal.navigation.Screen
import com.agonlabs.nefesal.ui.screens.achievements.AchievementsScreen
import com.agonlabs.nefesal.ui.screens.home.HomeScreen
import com.agonlabs.nefesal.ui.screens.settings.SettingsScreen
import com.agonlabs.nefesal.ui.screens.splash.SplashScreen
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.agonlabs.nefesal.ui.screens.home.HomeViewModel
import com.agonlabs.nefesal.R
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.agonlabs.nefesal.data.PolicyType
import com.agonlabs.nefesal.ui.screens.settings.policies.PoliciesScreen
import com.agonlabs.nefesal.util.LocalLocalization
import com.agonlabs.nefesal.util.LocalizationState
import com.agonlabs.nefesal.util.localizedStringResource

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NefesAlApp(
    viewModel: HomeViewModel = hiltViewModel(),
    localeViewModel: LocaleViewModel = hiltViewModel()
) {
    val currentLocale by localeViewModel.currentLocale.collectAsState()
    
    CompositionLocalProvider(
        LocalLocalization provides LocalizationState(currentLocale)
    ) {
        val switchState by viewModel.isDarkMode.collectAsState()
        val navController = rememberNavController()
        val items = listOf(
            Triple(Screen.Home, localizedStringResource(R.string.nav_home), Icons.Default.Home),
            Triple(Screen.Achievements, localizedStringResource(R.string.nav_achievements), Icons.Default.Star),
            Triple(Screen.Settings, localizedStringResource(R.string.nav_settings), Icons.Default.Settings)
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
                                                MaterialTheme.colorScheme.secondary
                                            } else {
                                                MaterialTheme.colorScheme.primary
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
                                                MaterialTheme.colorScheme.secondary
                                            } else {
                                                MaterialTheme.colorScheme.primary
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
                composable(Screen.Settings.route) { SettingsScreen(navController = navController) }
                composable(
                    Screen.Policies.route,
                    arguments = listOf(navArgument("policyType") { type = NavType.IntType })
                ) { backStackEntry ->
                    val policyTypeInt = backStackEntry.arguments?.getInt("policyType") ?: 1
                    val policyType = PolicyType.entries.first { it.type == policyTypeInt}
                    PoliciesScreen(navController = navController, policyType = policyType)
                }
            }
        }
    }
} 