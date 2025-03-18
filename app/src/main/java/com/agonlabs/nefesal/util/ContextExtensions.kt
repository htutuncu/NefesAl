package com.agonlabs.nefesal.util

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import java.util.Locale

fun Context.updateLocale(locale: Locale): ContextWrapper {
    val config = Configuration(resources.configuration)
    config.setLocale(locale)
    return ContextWrapper(createConfigurationContext(config))
} 