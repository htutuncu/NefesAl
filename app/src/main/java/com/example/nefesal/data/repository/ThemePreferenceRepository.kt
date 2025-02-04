package com.example.nefesal.data.repository

import com.example.nefesal.data.local.dao.ThemePreferenceDao
import com.example.nefesal.data.local.entity.ThemePreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ThemePreferenceRepository @Inject constructor(
    private val themePreferenceDao: ThemePreferenceDao
) {
    val isDarkTheme: Flow<Boolean> = themePreferenceDao.getThemePreference()
        .map { it?.isDarkTheme ?: false }

    suspend fun setDarkTheme(isDark: Boolean) {
        themePreferenceDao.setThemePreference(ThemePreference(isDarkTheme = isDark))
    }
} 