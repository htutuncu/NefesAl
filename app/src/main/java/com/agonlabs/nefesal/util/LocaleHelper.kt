package com.agonlabs.nefesal.util

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import java.util.Locale

object LocaleHelper {
    fun updateLocale(context: Context, languageCode: String?): Context {
        val locale = when (languageCode) {
            "en" -> Locale("en")
            "tr" -> Locale("tr")
            else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales[0]
            } else {
                context.resources.configuration.locale
            }
        }

        Locale.setDefault(locale)
        val config = Configuration(context.resources.configuration)
        
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocales(LocaleList(locale))
        } else {
            config.locale = locale
        }

        return context.createConfigurationContext(config)
    }
} 