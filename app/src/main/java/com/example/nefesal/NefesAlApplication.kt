package com.example.nefesal

import android.app.Application
import android.content.Context
import com.example.nefesal.util.LocaleHelper
import com.example.nefesal.util.PreferencesManager
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltAndroidApp
class NefesAlApplication : Application() {
    @Inject
    lateinit var preferencesManager: PreferencesManager

    override fun onCreate() {
        super.onCreate()
        
        // Dil ayarını uygula
        val context = LocaleHelper.updateLocale(
            this,
            runBlocking { preferencesManager.language.first() }
        )
        
        resources.updateConfiguration(
            context.resources.configuration,
            context.resources.displayMetrics
        )
    }
} 