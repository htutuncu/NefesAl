package com.agonlabs.nefesal

import android.app.Application
import com.agonlabs.nefesal.util.LocaleHelper
import com.agonlabs.nefesal.util.PreferencesManager
import com.google.firebase.FirebaseApp
import com.google.firebase.crashlytics.FirebaseCrashlytics
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

        FirebaseApp.initializeApp(this)
        FirebaseCrashlytics.getInstance().isCrashlyticsCollectionEnabled = !BuildConfig.IS_DEBUG

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