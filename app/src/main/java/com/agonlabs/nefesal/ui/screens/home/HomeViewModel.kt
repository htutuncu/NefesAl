package com.agonlabs.nefesal.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agonlabs.nefesal.data.SmokingData
import com.agonlabs.nefesal.util.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()

    private val _quitDate = MutableStateFlow<LocalDateTime?>(null)
    val quitDate: StateFlow<LocalDateTime?> = _quitDate.asStateFlow()

    private val _smokingData = MutableStateFlow<SmokingData?>(null)
    val smokingData: StateFlow<SmokingData?> = _smokingData.asStateFlow()

    init {
        viewModelScope.launch {
            preferencesManager.isDarkMode.collect { isDark ->
                _isDarkMode.value = isDark
            }
        }
        viewModelScope.launch {
            preferencesManager.quitDate.collect { date ->
                _quitDate.value = date
            }
        }
        viewModelScope.launch {
            preferencesManager.smokingData.collect { data ->
                _smokingData.value = data
            }
        }
    }

    fun toggleDarkMode() {
        viewModelScope.launch {
            val newMode = !_isDarkMode.value
            _isDarkMode.value = newMode
            preferencesManager.setDarkMode(newMode)
        }
    }

    fun setQuitDate(date: LocalDateTime) {
        viewModelScope.launch {
            preferencesManager.setQuitDate(date)
        }
    }

    fun resetQuitDate() {
        viewModelScope.launch {
            preferencesManager.resetQuitDate()
        }
    }

    fun resetSmokingData() {
        viewModelScope.launch {
            preferencesManager.resetSmokingData()
        }
    }

    fun setSmokingData(cigarettesPerDay: Int, pricePerPack: Double, minutesPerCigarette: Int) {
        viewModelScope.launch {
            preferencesManager.setSmokingData(
                SmokingData(
                    cigarettesPerDay = cigarettesPerDay,
                    pricePerPack = pricePerPack,
                    minutesPerCigarette = minutesPerCigarette
                )
            )
        }
    }

    fun getLocalizedString(id: Int, vararg args: Any): String {
        return preferencesManager.localizedStringResource(id, *args)
    }
} 