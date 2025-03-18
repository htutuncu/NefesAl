package com.agonlabs.nefesal.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.agonlabs.nefesal.data.SmokingData
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.time.LocalDateTime
import javax.inject.Inject
import javax.inject.Singleton
import android.content.res.Configuration
import kotlinx.coroutines.runBlocking
import java.util.Locale

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val dataStore = context.dataStore

    private val smokingDataStore = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }

    val isDarkMode: Flow<Boolean> = dataStore.data.map { preferences ->
        preferences[IS_DARK_MODE] ?: false
    }

    val quitDate: Flow<LocalDateTime?> = dataStore.data.map { preferences ->
        preferences[QUIT_DATE]?.let { timestamp ->
            LocalDateTime.ofEpochSecond(timestamp, 0, java.time.ZoneOffset.UTC)
        }
    }

    val language: Flow<String?> = dataStore.data.map { preferences ->
        preferences[LANGUAGE]
    }

    val smokingData: Flow<SmokingData?> = dataStore.data.map { preferences ->
        val cigarettesPerDay = preferences[CIGARETTES_PER_DAY]
        val pricePerPack = preferences[PRICE_PER_PACK]
        val minutesPerCigarette = preferences[MINUTES_PER_CIGARETTE]
        if (cigarettesPerDay != null && pricePerPack != null && minutesPerCigarette != null) {
            SmokingData(cigarettesPerDay, pricePerPack, minutesPerCigarette)
        } else null
    }

    suspend fun setDarkMode(isDarkMode: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_DARK_MODE] = isDarkMode
        }
    }

    suspend fun setQuitDate(date: LocalDateTime) {
        dataStore.edit { preferences ->
            preferences[QUIT_DATE] = date.toEpochSecond(java.time.ZoneOffset.UTC)
        }
    }

    suspend fun resetQuitDate() {
        dataStore.edit { preferences ->
            preferences.remove(QUIT_DATE)
        }
    }

    suspend fun setLanguage(languageCode: String) {
        dataStore.edit { preferences ->
            preferences[LANGUAGE] = languageCode
        }
    }

    suspend fun setSmokingData(data: SmokingData) {
        dataStore.edit { preferences ->
            preferences[CIGARETTES_PER_DAY] = data.cigarettesPerDay
            preferences[PRICE_PER_PACK] = data.pricePerPack
            preferences[MINUTES_PER_CIGARETTE] = data.minutesPerCigarette
        }
    }

    suspend fun resetSmokingData() {
        dataStore.edit { preferences ->
            preferences.remove(CIGARETTES_PER_DAY)
            preferences.remove(PRICE_PER_PACK)
            preferences.remove(MINUTES_PER_CIGARETTE)
        }
    }

    fun localizedStringResource(id: Int, vararg args: Any): String {
        val currentLanguage = runBlocking { language.first() }
        
        val locale = when (currentLanguage) {
            "tr" -> Locale("tr")
            "en" -> Locale("en")
            else -> Locale.getDefault()
        }

        val configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)
        val localizedContext = context.createConfigurationContext(configuration)

        return localizedContext.getString(id, *args)
    }

    companion object {
        private val IS_DARK_MODE = booleanPreferencesKey("is_dark_mode")
        private val QUIT_DATE = longPreferencesKey("quit_date")
        private val LANGUAGE = stringPreferencesKey("language")
        private val CIGARETTES_PER_DAY = intPreferencesKey("cigarettes_per_day")
        private val PRICE_PER_PACK = doublePreferencesKey("price_per_pack")
        private val MINUTES_PER_CIGARETTE = intPreferencesKey("minutes_per_cigarette")
    }
}
