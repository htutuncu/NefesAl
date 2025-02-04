package com.example.nefesal.ui.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nefesal.data.repository.ThemePreferenceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val themePreferenceRepository: ThemePreferenceRepository
) : ViewModel() {
    val isDarkTheme = themePreferenceRepository.isDarkTheme

    fun setDarkTheme(isDark: Boolean) {
        viewModelScope.launch {
            themePreferenceRepository.setDarkTheme(isDark)
        }
    }
} 