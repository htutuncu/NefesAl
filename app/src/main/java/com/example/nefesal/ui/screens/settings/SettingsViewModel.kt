package com.example.nefesal.ui.screens.settings

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nefesal.util.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    private val _selectedLanguage = MutableStateFlow<String?>(null)
    val selectedLanguage: StateFlow<String?> = _selectedLanguage.asStateFlow()

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    init {
        viewModelScope.launch {
            preferencesManager.language.collect { language ->
                _selectedLanguage.value = language
            }
        }
        viewModelScope.launch {
            preferencesManager.isDarkMode.collect { isDark ->
                _isDarkMode.value = isDark
            }
        }
    }

    fun setLanguage(languageCode: String?) {
        viewModelScope.launch {
            preferencesManager.setLanguage(languageCode ?: "")
        }
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            val newMode = !_isDarkMode.value
            _isDarkMode.value = newMode
            preferencesManager.setDarkMode(newMode)
        }
    }
} 