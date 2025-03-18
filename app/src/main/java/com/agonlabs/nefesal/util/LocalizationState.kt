package com.agonlabs.nefesal.util

import androidx.compose.runtime.compositionLocalOf
import java.util.Locale

data class LocalizationState(
    val locale: Locale = Locale.getDefault()
)

val LocalLocalization = compositionLocalOf { LocalizationState() } 