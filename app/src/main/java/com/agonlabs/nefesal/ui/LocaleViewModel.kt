package com.agonlabs.nefesal.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agonlabs.nefesal.util.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
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
                val newLocale = when (languageCode) {
                    "en" -> Locale("en")
                    "tr" -> Locale("tr")
                    else -> Locale.getDefault()
                }
                _currentLocale.value = newLocale
                if (languageCode == null) {
                    setCurrentDefaultLocale()
                }
            }
        }
    }

    private fun setCurrentDefaultLocale() {
        viewModelScope.launch {
            val defaultLanguage = Locale.getDefault().language
            if (defaultLanguage !in listOf("tr", "en")) {
                preferencesManager.setLanguage("en") // Telefon dili Türkçe değilse "en" olarak kaydet
                _currentLocale.value = Locale("en")
            } else {
                preferencesManager.setLanguage(defaultLanguage) // Telefon dili desteklenen bir dilse onu kaydet
                _currentLocale.value = Locale(defaultLanguage)
            }
        }
    }
} 