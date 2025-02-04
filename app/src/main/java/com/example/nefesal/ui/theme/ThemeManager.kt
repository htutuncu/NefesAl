package com.example.nefesal.ui.theme

import com.example.nefesal.data.repository.ThemePreferenceRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeManager @Inject constructor(
    themePreferenceRepository: ThemePreferenceRepository
) {
    val isDarkTheme = themePreferenceRepository.isDarkTheme
} 