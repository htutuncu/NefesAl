package com.example.nefesal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nefesal.util.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class LocaleViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {
    private val _currentLocale = MutableStateFlow(Locale.getDefault())
    val currentLocale: StateFlow<Locale> = _currentLocale.asStateFlow()

    init {
        viewModelScope.launch {
            preferencesManager.language.collect { languageCode ->
                _currentLocale.value = when (languageCode) {
                    "en" -> Locale("en")
                    "tr" -> Locale("tr")
                    else -> Locale.getDefault()
                }
            }
        }
    }
} 