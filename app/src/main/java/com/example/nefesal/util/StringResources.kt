package com.example.nefesal.util

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource

@Composable
fun localizedStringResource(id: Int): String {
    val context = LocalContext.current
    val localization = LocalLocalization.current
    
    return context.createConfigurationContext(
        context.resources.configuration.apply {
            setLocale(localization.locale)
        }
    ).getString(id)
} 