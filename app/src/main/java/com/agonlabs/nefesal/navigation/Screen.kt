package com.agonlabs.nefesal.navigation

import com.agonlabs.nefesal.data.PolicyType

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Achievements : Screen("achievements")
    object Settings : Screen("settings")
    object Policies : Screen("policies/{policyType}") {
        fun createRoute(policyType: PolicyType) = "policies/${policyType.type}"
    }
} 